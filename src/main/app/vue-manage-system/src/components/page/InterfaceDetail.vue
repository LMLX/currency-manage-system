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
                <el-form ref="selectForm" :model="form" label-width="80px">
                    <el-form-item label="模板名称">
                        <el-select v-model="value" placeholder="请选择">
                            <el-option
                                v-for="item in modelSelect"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="接口名称">
                        <el-input v-model="selectForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="接口描述">
                        <el-input v-model="selectForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="接口类型">
                        <el-input v-model="selectForm.name"></el-input>
                    </el-form-item>
                </el-form>
<!--                <el-button-->
<!--                    type="primary"-->
<!--                    icon="el-icon-delete"-->
<!--                    class="handle-del mr10"-->
<!--                    @click="delAllSelection"-->
<!--                >批量删除-->
<!--                </el-button>-->
<!--                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>-->
<!--                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>-->
<!--                <el-button style="float: right" type="primary" icon="el-icon-search" @click="handleAdd">添加</el-button>-->
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange"
                row-key="interfaceId"
                :expand-row-keys="expandRowKeys"
                @row-click="showDetail"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column type="expand">
                    <template slot-scope="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                            <el-form-item label="商品名称">
                                <span>{{ props.row.name }}</span>
                            </el-form-item>
                            <el-form-item label="所属店铺">
                                <span>{{ props.row.shop }}</span>
                            </el-form-item>
                            <el-form-item label="商品 ID">
                                <span>{{ props.row.id }}</span>
                            </el-form-item>
                            <el-form-item label="店铺 ID">
                                <span>{{ props.row.shopId }}</span>
                            </el-form-item>
                            <el-form-item label="商品分类">
                                <span>{{ props.row.category }}</span>
                            </el-form-item>
                            <el-form-item label="店铺地址">
                                <span>{{ props.row.address }}</span>
                            </el-form-item>
                            <el-form-item label="商品描述">
                                <span>{{ props.row.desc }}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column prop="modelName" label="模板名称" align="center"></el-table-column>
                <el-table-column prop="interfaceName" label="接口名称" align="center"></el-table-column>
                <el-table-column prop="interfaceUrl" label="接口路径"></el-table-column>
                <el-table-column prop="interfaceDesc" label="接口描述"></el-table-column>
                <el-table-column prop="type" label="接口类型"></el-table-column>
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
                <el-form-item label="模板名称">
                    <el-input v-model="form.modelId"></el-input>
                </el-form-item>
                <el-form-item label="接口名称">
                    <el-input v-model="form.interfaceName"></el-input>
                </el-form-item>
                <el-form-item label="接口路径">
                    <el-input v-model="form.interfaceUrl"></el-input>
                </el-form-item>
                <el-form-item label="接口描述">
                    <el-input v-model="form.interfaceDesc"></el-input>
                </el-form-item>
                <el-form-item label="接口类型">
                    <el-input v-model="form.type"></el-input>
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
        name: 'interfaceDetail',
        data() {
            return {
                query: {
                    appId:'',
                    pageIndex: 1,
                    pageSize: 2
                },
                pageIndex: 1,
                pageSize: 2,
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                dialogTitle:'',
                pageTotal: 0,
                form: {},
                data: {
                },
                expandRowKeys:[],
                selectForm:{name:'333'},
                modelSelect:[{
                  value: '选项1',
                  label: '黄金糕'
                }, {
                  value: '选项2',
                  label: '双皮奶'
                }]
            };
        },
        created() {
            let appId = this.$route.params.appId
            this.query.appId = appId
            this.getData();
        },
        methods: {
            // 获取 easy-mock 的模拟数据
            getData() {
                let self = this;
                console.log("dd: " + self.query.appId)
                let data = {
                    appId: this.$route.params.appId,
                    pageNum: self.query.pageIndex,
                    pageSize: self.query.pageSize,
                }
                self.$post("/base/interface/qryDetailList", data).then(function (response) {
                    if (response.status == 0) {
                        self.tableData = response.obj.list;
                        self.pageTotal = response.obj.total;
                    }
                }).catch(function (err) {

                })

            },
            getInterfaceId(row) {
                console.log(row.interfaceId)
                return row.interfaceId // 每条数据的唯一识别值
            },
            // 触发搜索按钮
            handleSearch() {
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
            //展示详情
            showDetail(row, column, event) {
                console.log(row)
                let self = this;
                let index = self.expandRowKeys.indexOf(row.interfaceId)
                if (index == -1) {
                    this.expandRowKeys.push(row.interfaceId)
                } else {
                    this.expandRowKeys.splice(index, 1)
                }
                // console.log(id)
                // let self = this;
                // this.dialogTitle = '修改';
                // this.form = JSON.parse(JSON.stringify(row))
                // this.form.updator = this.common.getLocalStorage("userInfo").userId;
                // this.editVisible = true;
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
                // self.$post("/base/app/merge", datas).then(function (response) {
                //     if (response.status == 0) {
                //         self.getData()
                //         self.editVisible = false;
                //     } else {
                //         self.$message.error(response.msg);
                //     }
                // }).catch(function (err) {
                //     self.$message.error(err);
                // })
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
