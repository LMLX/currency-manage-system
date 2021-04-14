<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 基础表格
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-button
                    type="primary"
                    icon="el-icon-delete"
                    class="handle-del mr10"
                    @click="delAllSelection"
                >批量删除
                </el-button>

                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button style="float: right" type="primary" icon="el-icon-search" @click="handleAdd">添加</el-button>
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
<!--                <el-table-column prop="appId" label="ID" width="55" align="center"></el-table-column>-->
                <el-table-column prop="appName" label="应用名称" align="center"></el-table-column>
                <el-table-column prop="appDesc" label="应用描述" align="center"></el-table-column>

                <el-table-column prop="appDevHost" label="测试端口"></el-table-column>
                <el-table-column prop="appProHost" label="生产端口"></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.row.appId, scope.row)"
                        >编辑
                        </el-button>
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.row.appId, scope.row)"
                        >删除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    @size-change="handleSizeChange"
                    @current-change="handlePageChange"
                    :current-page="query.pageIndex"
                    :page-sizes="[2, 10, 30]"
                    :page-size="query.pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="pageTotal">
                </el-pagination>
            </div>

        </div>

        <!-- 编辑弹出框 -->
        <el-dialog :title="dialogTitle" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="应用名称">
                    <el-input v-model="form.appName"></el-input>
                </el-form-item>
                <el-form-item label="应用描述">
                    <el-input v-model="form.appDesc"></el-input>
                </el-form-item>
                <el-form-item label="测试端口">
                    <el-input v-model="form.appDevHost"></el-input>
                </el-form-item>
                <el-form-item label="生产端口">
                    <el-input v-model="form.appProHost"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: 'app',
        data() {
            return {
                query: {
                    address: '',
                    name: '',
                    pageIndex: 1,
                    pageSize: 2
                },
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                dialogTitle:'',
                pageTotal: 0,
                form: {},
                data: {
                }
            };
        },
        created() {
            this.getData();
        },
        methods: {
            // 获取 easy-mock 的模拟数据
            getData() {
                let self = this;
                let data = {
                    pageNum: self.query.pageIndex,
                    pageSize: self.query.pageSize,
                }
                self.$post("/base/app/qryAll", data).then(function (response) {
                    if (response.status == 0) {
                        self.tableData = response.obj.list;
                        self.pageTotal = response.obj.total;
                    }
                }).catch(function (err) {

                })

            },
            // 触发搜索按钮
            handleSearch() {
                this.$set(this.query, 'pageIndex', 1);
                this.getData();
            },
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                })
                    .then(() => {
                        this.$message.success('删除成功');
                        // this.tableData.splice(index, 1);
                    })
                    .catch(() => {
                    });
            },
            // 多选操作
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            delAllSelection() {
                const length = this.multipleSelection.length;
                let str = '';
                this.delList = this.delList.concat(this.multipleSelection);
                for (let i = 0; i < length; i++) {
                    str += this.multipleSelection[i].name + ' ';
                }
                this.$message.error(`删除了${str}`);
                this.multipleSelection = [];
            },
            // 编辑操作
            handleEdit(id, row) {
                console.log(id)

                let self = this;
                this.dialogTitle = '修改';
                this.form = JSON.parse(JSON.stringify(row))
                this.form.updator = this.common.getLocalStorage("userInfo").userId;
                this.editVisible = true;
            },

            //添加
            handleAdd() {
                this.dialogTitle = '添加';
                this.form = {}
                this.form.creator = this.common.getLocalStorage("userInfo").userId;
                this.editVisible = true;
            },
            // 保存编辑
            saveEdit() {
                let self = this;
                // this.$message.success(`修改第 ${this.idx + 1} 行成功`);
                // this.$set(this.tableData, this.idx, this.form);
                console.log(self.form)
                let datas = []
                datas.push(self.form)
                self.$post("/base/app/merge", datas).then(function (response) {
                    if (response.status == 0) {
                        self.getData()
                        self.editVisible = false;
                    } else {
                        self.$message.error(response.msg);
                    }
                }).catch(function (err) {
                    self.$message.error(err);
                })
            },
            // 分页导航
            handlePageChange(val) {
                this.$set(this.query, 'pageIndex', val);
                this.getData();
            },
            handleSizeChange(val) {
                this.query.pageSize = val
                this.getData()
            },
        }
    };
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }

    .table {
        width: 100%;
        font-size: 14px;
    }

    .red {
        color: #ff0000;
    }

    .mr10 {
        margin-right: 10px;
    }

    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
</style>
