<template>
    <div>
<!--        <div class="crumbs">-->
<!--            <el-breadcrumb separator="/">-->
<!--                <el-breadcrumb-item>-->
<!--                    <i class="el-icon-lx-cascades"></i> 基础表格-->
<!--                </el-breadcrumb-item>-->
<!--            </el-breadcrumb>-->
<!--        </div>-->
        <div class="container">
            <div class="handle-box">

                <el-form ref="searchAppForm" :inline="true" :model="searchAppForm" class="search-app-form">
                    <el-form-item label="应用ID" prop="appId" :rules="[
                      { type: 'number', message: '应用ID必须为数字值'}
                    ]">
                        <el-input v-model.number="searchAppForm.appId" placeholder="应用ID"></el-input>
                    </el-form-item>
                    <el-form-item label="应用名称" prop="appName">
                        <el-input v-model="searchAppForm.appName" placeholder="应用名称"></el-input>
                    </el-form-item>
                    <el-form-item label="应用描述" prop="appDesc">
                        <el-input v-model="searchAppForm.appDesc" placeholder="应用描述"></el-input>
                    </el-form-item>
                    <el-form-item style="float: right">


                        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                        <el-button type="info" @click="resetForm('searchAppForm')">重置</el-button>
                        <el-button type="danger"
                                   icon="el-icon-delete"
                                   @click="delAllSelection">批量删除</el-button>
                        <el-button  type="warning" icon="el-icon-search" @click="handleAdd">添加</el-button>
                    </el-form-item>
                </el-form>




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
                <el-table-column prop="appName" label="应用名称" align="center"></el-table-column>
                <el-table-column prop="appDesc" label="应用描述" align="center"></el-table-column>

                <el-table-column prop="appDevHost" label="测试地址"></el-table-column>
                <el-table-column prop="appProHost" label="生产地址"></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-search"
                            class="green"
                            @click="showDetail(scope.row.appId, scope.row)"
                        >查看
                        </el-button>
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            class="yellow"
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
                    :current-page="searchAppForm.pageNum"
                    :page-sizes="[5, 10, 30]"
                    :page-size="searchAppForm.pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="pageTotal">
                </el-pagination>
            </div>

        </div>

        <!-- 编辑弹出框 -->
        <el-dialog :title="dialogTitle" :visible.sync="editVisible" width="30%">
            <el-form ref="mergeAppForm" :model="mergeAppForm" label-width="70px">
                <el-form-item label="应用名称">
                    <el-input v-model="mergeAppForm.appName"></el-input>
                </el-form-item>
                <el-form-item label="应用描述">
                    <el-input v-model="mergeAppForm.appDesc"></el-input>
                </el-form-item>
                <el-form-item label="测试端口">
                    <el-input v-model="mergeAppForm.appDevHost"></el-input>
                </el-form-item>
                <el-form-item label="生产端口">
                    <el-input v-model="mergeAppForm.appProHost"></el-input>
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
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                dialogTitle:'',
                pageTotal: 0,
                mergeAppForm: {},
                searchAppForm:{
                    pageNum: 1,
                    pageSize: 5,
                },
                data: {
                },
            };
        },
        created() {
            this.getData();
        },
        methods: {
            // 获取 easy-mock 的模拟数据
            getData() {
                let self = this
                let data = self.searchAppForm
                self.$post("/base/app/qryAll", data).then(function (response) {
                    if (response.status == 0) {
                        self.tableData = response.obj.list;
                        self.pageTotal = response.obj.total;
                    } else {
                        self.$message.error(response.msg);
                    }
                }).catch(function (err) {
                })

            },
            // 触发搜索按钮
            handleSearch() {
                this.$set(this.searchAppForm, 'pageNum', 1);
                this.getData();
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
                this.getData();
            },
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                let self = this;
                let data = [];
                data.push(row);
                this.deleteConfirm(data);
            },
            deleteConfirm(data) {
                let self = this;
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                    self.$post("/base/app/delete", data).then(function (response) {
                        if (response.status == 0) {
                            self.$message.success('删除成功');
                            self.getData();
                        }
                    })
                }).catch(() => {
                });
            },
            // 多选操作
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            delAllSelection() {
                let self = this;
                let data = [];
                for (let i = 0; i < self.multipleSelection.length; i++) {
                    data.push(self.multipleSelection[i]);
                }
                // this.$message.error(`删除了${str}`);
                this.deleteConfirm(data);
                this.multipleSelection = [];
            },
            //展示详情
            showDetail(id, row) {
                console.log(id)
                this.$router.push({
                    name: 'interfaceDetail',
                    params: {
                        appId:id
                    }
                });
            },
            // 编辑操作
            handleEdit(id, row) {
                console.log(id)
                this.dialogTitle = '修改';
                this.mergeAppForm = JSON.parse(JSON.stringify(row))
                this.mergeAppForm.updator = this.common.getLocalStorage("userInfo").userId;
                this.editVisible = true;
                this.getData();
            },

            //添加
            handleAdd() {
                this.dialogTitle = '添加';
                this.mergeAppForm.creator = this.common.getLocalStorage("userInfo").userId;
                this.editVisible = true;
            },
            // 保存编辑
            saveEdit() {
                let self = this;
                console.log(self.mergeAppForm)
                let datas = []
                datas.push(self.mergeAppForm)
                self.$post("/base/app/merge", datas).then(function (response) {
                    if (response.status == 0) {
                        self.getData()
                        self.editVisible = false;
                        self.mergeAppForm = {}
                    } else {
                        self.$message.error(response.msg);
                    }
                }).catch(function (err) {
                    self.$message.error(err);
                })
            },
            // 分页导航
            handlePageChange(val) {
                this.$set(this.searchAppForm, 'pageNum', val);
                this.getData();
            },
            handleSizeChange(val) {
                this.searchAppForm.pageSize = val
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



    .mr10 {
        margin-right: 10px;
    }

    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
    .search-app-form {

    }
</style>
