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
            <el-container>
                <el-aside width="350px">
                    <el-header style="height: 50px;">
                        <el-row>
                            <el-col :span="18"><div class="grid-content bg-purple">模板分类</div></el-col>
                            <el-col :span="6">
                                <span>
                                    <el-button size="mini"  type="primary" icon="el-icon-circle-plus-outline" v-bind:disabled="!selectForm.appId" @click=appendModel({appId:selectForm.appId})></el-button>
                                </span>
                            </el-col>

                        </el-row>

                    </el-header>
                    <el-main>
                        <div class="custom-tree-container">
                            <div class="block" >
                                <el-tree
                                    :data="modelData"
                                    node-key="modelId"
                                    default-expand-all
                                    :expand-on-click-node="false"
                                    :render-content="renderContent">
                                </el-tree>
                            </div>
                        </div>
                    </el-main>
                </el-aside>
                <el-main>
                    <div class="handle-box">
                        <el-form :inline="true" ref="selectForm" :model="selectForm" label-width="80px">
                            <el-form-item label="应用名称">
                                <el-select filterable clearable v-model="selectForm.appId" placeholder="请选择" @change="changeAppId">
                                    <el-option

                                        v-for="item in appSelect"
                                        :key="item.selectAppId"
                                        :label="item.label"
                                        :value="item.selectAppId">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="模板名称">
                                <el-cascader
                                    ref="modelCascader" filterable clearable v-bind:disabled="!selectForm.appId"
                                    v-model="selectForm.modelIds"
                                    :options="modelSelect"
                                    :props="modelCascadesProps"
                                    :show-all-levels="false"
                                    :key="cascaderKey"
                                    collapse-tags
                                    @change="change"></el-cascader>
                            </el-form-item>
                            <el-form-item label="接口名称">
                                <el-input v-model="selectForm.name"></el-input>
                            </el-form-item>
                            <el-form-item label="接口描述">
                                <el-input v-model="selectForm.desc"></el-input>
                            </el-form-item>
                            <el-form-item label="接口类型">
                                <el-input v-model="selectForm.type"></el-input>
                            </el-form-item>
                            <el-form-item style="float: right">


                                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                                <el-button type="info" @click="resetForm('selectForm')">重置</el-button>
                                <el-button type="danger"
                                           icon="el-icon-delete"
                                           @click="delAllSelection">批量删除</el-button>
                                <el-button  type="warning" icon="el-icon-search" @click="handleAdd">添加</el-button>
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
                    >
                        <el-table-column type="selection" width="55" align="center"></el-table-column>
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
                            :current-page="selectForm.pageNum"
                            :page-sizes="[2, 10, 30]"
                            :page-size="selectForm.pageSize"
                            layout="total, sizes, prev, pager, next, jumper"
                            :total="pageTotal">
                        </el-pagination>
                    </div>
                </el-main>
            </el-container>
        </div>

<!--        模板编辑-->
        <el-dialog :title="dialogTitle" :visible.sync="modelEditVisible" width="30%">
            <el-form ref="modelEditform" :rules="rules" :model="modelEditform" label-width="80px">
                <el-form-item label="模板名称" prop="modelName">
                    <el-input v-model="modelEditform.modelName"></el-input>
                </el-form-item>
                <el-form-item label="模板路径" >
                    <el-input v-model="modelEditform.modelUrl" placeholder="/开头"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="modelEditVisible = false">取 消</el-button>
                <el-button type="primary" @click="modelMerge">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>

let id = 1000;
export default {
    name: 'interfaceDetail',
    data() {
        return {
            tableData: [],
            multipleSelection: [],
            delList: [],
            modelEditVisible: false,
            dialogTitle: '',
            pageTotal: 0,

            data: {},
            selectForm: {
                // appId: this.$route.params.appId,
                pageNum: 1,
                pageSize: 2,
                appId: null,
                modelIds: [],
                modelId: null,
                name: null,
                desc: null,
                type: null
            },
            appSelect: [],
            modelCascadesProps: {
                checkStrictly: true,
                value: "modelId",
                label: "modelName"
            },
            modelSelect: [],
            modelData:[],
            modelEditform: {},
            rules: {
                modelName:[
                    { required: true, message: '请输入模板名称', trigger: 'blur' },
                    { min: 1, message: '必填项', trigger: 'blur' }
                ]
            },
            cascaderKey:0
        };
    },
    created() {
        let appId = this.$route.params.appId
        this.qryAllApp()
        if (null != appId && undefined != appId) {
            this.selectForm.appId = appId
            //查询模板
            this.qryModelInfo()
        }
        this.getData()
    },
    methods: {
        // 获取 easy-mock 的模拟数据
        getData() {
            let self = this;
            let data = this.selectForm
            self.$post("/base/interface/qryDetailList", data).then(function (response) {
                if (response.status == 0) {
                    self.tableData = response.obj.list;
                    self.pageTotal = response.obj.total;
                }
            }).catch(function (err) {

            })

        },
        change() {
            let currentNode = this.$refs["modelCascader"].getCheckedNodes()
            if (null != currentNode && undefined != currentNode && currentNode.length > 0) {
                this.selectForm.modelId = currentNode[0].data.modelId
            }
        },
        qryAllApp() {
            let self = this
            self.$post("/base/app/qryAll", {pageSize: 0, pageNum: 0}).then(function (response) {
                if (response.status == 0) {
                    console.log(response)
                    for (let i = 0; i < response.obj.list.length; i++) {
                        self.appSelect.push({
                            label: response.obj.list[i].appName,
                            selectAppId: response.obj.list[i].appId
                        })
                    }
                }
            }).catch(function (err) {
                console.log(err)
            })
        },
        changeAppId() {
            this.cascaderKey++;
            this.qryModelInfo()
        },
        qryModelInfo() {
            let self = this
            self.modelSelect = []
            self.$post("/base/model/qryModelTreeByAppId", {appId: self.selectForm.appId}).then(function (response) {
                if (response.status == 0) {
                    console.log(response)
                    self.modelData = response.obj
                    self.modelSelect = response.obj
                }
            }).catch(function (err) {
                console.log(err)
            })
        },
        // 触发搜索按钮
        handleSearch() {
            this.$set(this.selectForm, 'pageNum', 1);
            this.getData();
        },
        // 删除操作
        handleDelete(index, row) {
            // 二次确认删除
            // this.$confirm('确定要删除吗？', '提示', {
            //     type: 'warning'
            // })
            //     .then(() => {
            //         this.$message.success('删除成功');
            //         // this.tableData.splice(index, 1);
            //     })
            //     .catch(() => {
            //     });
        },
        // 多选操作
        handleSelectionChange(val) {
            // this.multipleSelection = val;
        },
        delAllSelection() {
            // const length = this.multipleSelection.length;
            // let str = '';
            // this.delList = this.delList.concat(this.multipleSelection);
            // for (let i = 0; i < length; i++) {
            //     str += this.multipleSelection[i].name + ' ';
            // }
            // this.$message.error(`删除了${str}`);
            // this.multipleSelection = [];
        },
        // 编辑操作
        handleEdit(id, row) {
            // console.log(id)
            //
            // let self = this;
            // this.dialogTitle = '修改';
            // this.form = JSON.parse(JSON.stringify(row))
            // this.form.updator = this.common.getLocalStorage("userInfo").userId;
            // this.editVisible = true;
        },

        //添加
        handleAdd() {
            // this.dialogTitle = '添加';
            // this.form = {}
            // this.form.creator = this.common.getLocalStorage("userInfo").userId;
            // this.editVisible = true;
        },
        // 保存编辑
        modelMerge() {
            let self = this;
            console.log( self.modelEditform)
            this.$refs["modelEditform"].validate((valid) => {
                if (valid) {
                    let data = self.modelEditform
                    self.$post("/base/model/merge", data).then(function (response) {
                        if (response.status == 0) {
                            self.qryModelInfo()
                            self.modelEditVisible = false;
                            self.modelEditform={}
                        } else {
                            self.$message.error(response.msg);
                        }
                    }).catch(function (err) {
                        self.$message.error(err);
                    })
                } else {
                    return false;
                }
            });




        },
        appendModel(data) {
            console.log(data)
            // const newChild = { id: id++, label: 'testtest', children: [] };
            // if (!data.children) {
            //     this.$set(data, 'children', []);
            // }
            // data.children.push(newChild);

            this.dialogTitle = '添加模板';
            this.modelEditform.pModelId = data.modelId
            this.modelEditform.creator = this.common.getLocalStorage("userInfo").userId;
            this.modelEditform.appId = data.appId
            this.modelEditVisible = true;
        },

        updateModel(data) {
            console.log(data)
            let self = this;
            this.dialogTitle = '修改模板';
            this.modelEditform.updator = this.common.getLocalStorage("userInfo").userId;
            this.$set(this.modelEditform, 'modelName', data.modelName)
            this.$set(this.modelEditform, 'modelUrl', data.modelUrl)
            this.$set(this.modelEditform, 'modelId', data.modelId)
            console.log(self.modelEditform)
            this.modelEditVisible = true;
        },

        removeModel(data) {
            let self = this;
            let modelIdList = []
            modelIdList.push(data.modelId)
            console.log(modelIdList)
            self.$post("/base/model/deleteByIds", modelIdList).then(function (response) {
                if (response.status == 0) {
                    self.qryModelInfo()
                    self.$message.success('删除成功');
                } else {
                    self.$message.error(response.msg);
                }
            }).catch(function (err) {
                self.$message.error(err);
            })

        },
        renderContent(h, { node, data, store }) {
            console.log(node.data.modelName)
            return (
                <span class="custom-tree-node">
            <span>{node.data.modelName}</span>
            <span>
                <el-button size="mini" class="blue" type="text" icon="el-icon-circle-plus-outline" circle on-click={ () => this.appendModel(data) }></el-button>
                <el-button size="mini" class="yellow" type="text" icon="el-icon-edit" circle on-click={ () => this.updateModel(data) }></el-button>
                <el-button size="mini" class="red" type="text" icon="el-icon-delete" circle on-click={ () => this.removeModel(data) }></el-button>
            </span>
          </span>);
        },
        // 分页导航
        handlePageChange(val) {
            this.$set(this.selectForm, 'pageNum', val);
            this.getData();
        },
        handleSizeChange(val) {
            this.selectForm.pageSize = val
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
.el-header, .el-footer {


    color: #555;
    text-align: left;
    border-bottom: 1px solid #EBEEF5;
    line-height: 50px;
}
.el-aside {
    text-align: center;
    border-right: 1px solid #EBEEF5;
    height: auto;
}
.el-main {
    padding: 10px;
    height: auto;
    overflow: hidden;
}

</style>
