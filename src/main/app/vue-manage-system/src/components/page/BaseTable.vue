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
                <el-cascader :options="query.liveAddress" v-model="query.selectedLiveAddress" @change="changeLiveAddress">
                </el-cascader>
                <el-input v-model="query.name" placeholder="用户名" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
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
                <!-- <el-table-column prop="userId" label="ID" width="55" align="center"></el-table-column> -->
                <el-table-column fixed prop="userName" label="姓名"></el-table-column>
                <el-table-column prop="sex" label="性别">
                    <template slot-scope="scope">
                        {{scope.row.sex == 1 ? "男" : scope.row.sex == 2 ? "女" : "未知"}}
                    </template>
                </el-table-column>
                <el-table-column label="头像(查看大图)" align="center">
                    <template slot-scope="scope">
                        <el-image
                            class="table-td-thumb"
                            :src="scope.row.thumb"
                            :preview-src-list="[scope.row.thumb]"
                        ></el-image>
                    </template>
                </el-table-column>
                <el-table-column prop="height" label="身高(cm)"></el-table-column>
                <el-table-column prop="weight" label="体重(斤)"></el-table-column>
                <el-table-column prop="age" label="年龄(周岁)"></el-table-column>
                <el-table-column prop="birthday" label="生日"></el-table-column>
                <el-table-column prop="liveAddressInfo" label="居住地址">
                </el-table-column>
                <el-table-column prop="workAddressInfo" label="工作地址"></el-table-column>
                <el-table-column prop="educationInfo" label="学历"></el-table-column>
                <el-table-column prop="salary" label="年薪(万)"></el-table-column>
                <el-table-column prop="hasHouse" label="房情况">
                    <template slot-scope="scope">
                        {{scope.row.hasHouse ? "有":"无"}}
                    </template>
                </el-table-column>
                <el-table-column prop="hasCar" label="车情况">
                     <template slot-scope="scope">
                        {{scope.row.hasCar ? "有":"无"}}
                    </template>
                </el-table-column>
                <el-table-column prop="is_only" label="独生子女">
                    <template slot-scope="scope">
                        {{scope.row.is_only ? "是":"否"}}
                    </template>
                </el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.$index, scope.row)"
                        >编辑
                        </el-button>
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.$index, scope.row)"
                        >删除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!--            <div class="pagination">-->
            <!--                <el-pagination-->
            <!--                    background-->
            <!--                    layout="total, prev, pager, next"-->
            <!--                    :current-page="query.pageIndex"-->
            <!--                    :page-size="query.pageSize"-->
            <!--                    :total="pageTotal"-->
            <!--                    @current-change="handlePageChange"-->
            <!--                ></el-pagination>-->
            <!--            </div>-->
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
        <el-dialog title="编辑" :visible.sync="editVisible" width="700px">
            <el-form ref="form" :model="form" label-width="90px" :inline="true">
                <el-row>

                    <el-form-item label="姓名">
                        <el-input v-model="form.userName"></el-input>
                    </el-form-item>
                    <el-form-item label="性别">
                        <el-select v-model="form.sex" placeholder="请选择">
                            <el-option
                            v-for="item in allSex"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>

                </el-row>
                <el-row>
                    <el-form-item label="身高">
                        <el-input v-model="form.height"></el-input>
                    </el-form-item>
                    <el-form-item label="体重">
                        <el-input v-model="form.weight"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="电话">
                        <el-input v-model="form.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="微信">
                        <el-input v-model="form.wechat"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="出生日期">
                        <!-- <el-input v-model="form.birthday"></el-input> -->
                        <el-date-picker
                        v-model="form.birthday"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>
                    <el-form-item label="年龄">
                        <el-input v-model="form.age" :disabled="true"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="居住地址">
                    <!-- <el-input v-model="form.height"></el-input> -->
                        <el-cascader :options="allAddressInfo" v-model="form.selectedLiveAddress" @change="changeLiveAddress">
                    </el-cascader>
                    </el-form-item>
                    <el-form-item label="详情地址">
                         <el-input v-model="form.liveAddress"></el-input>
                    </el-form-item>

                </el-row>
                <el-row>
                    <el-form-item label="工作地址">
                        <el-cascader :options="allAddressInfo" v-model="form.selectedWorkAddress" @change="changeLiveAddress">
                        </el-cascader>
                    </el-form-item>
                    <el-form-item label="详情地址">
                        <el-input v-model="form.workAddress"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="职业">
                        <!-- <el-input v-model="form.occupationType"></el-input> -->
                        <el-cascader
                        v-model="form.occupationType"
                        :options="allOccupationType"
                        @change="changeOccupationType">
                        </el-cascader>
                    </el-form-item>
                    <el-form-item label="职业备注">
                        <el-input v-model="form.occupationMark"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="年薪">
                        <el-input v-model="form.salary"></el-input>
                    </el-form-item>
                    <el-form-item label="生肖">
                        <el-input v-model="form.zodiac" :disabled="true"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="学历">
                        <!-- <el-input v-model="form.education"></el-input> -->
                        <el-select v-model="form.education" placeholder="请选择">
                            <el-option
                            v-for="item in allEducation"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="学历备注">
                        <el-input v-model="form.educationMark"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="婚姻情况">
                        <!-- <el-input v-model="form.isMarried"></el-input> -->
                        <el-select v-model="form.isMarried" placeholder="请选择">
                            <el-option
                            v-for="item in allMarried"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="婚姻备注">
                        <el-input v-model="form.marriedMark"></el-input>
                    </el-form-item>
                </el-row>
                    <el-form-item label="独生子女">
                        <el-select v-model="form.isOnly" placeholder="请选择">
                            <el-option
                            v-for="item in allOnly"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="家庭备注">
                        <el-input v-model="form.onlyMark"></el-input>
                    </el-form-item>
                <el-row>
                    <el-form-item label="房情况">
                        <el-select v-model="form.hasHouse" placeholder="请选择">
                            <el-option
                            v-for="item in allHouse"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="房情况备注">
                        <el-input v-model="form.houseMark"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="车情况">
                        <el-select v-model="form.hasCar" placeholder="请选择">
                            <el-option
                            v-for="item in allCar"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="车情况备注">
                        <el-input v-model="form.carMark"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="编号">
                        <el-input v-model="form.account"></el-input>
                    </el-form-item>

                </el-row>
                <el-row>
                    <el-form-item label="照片">
                        <el-upload
                            class="upload-demo"
                            action="http://localhost:8081/base/user/upload"
                            :on-preview="handlePreview"
                            :on-remove="handleRemove"
                            :file-list="fileList"
                            :on-success="uploadSuccess"
                            list-type="picture">
                            <el-button size="small" type="primary">点击上传</el-button>
                            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                        </el-upload>
                    </el-form-item>
                </el-row>

            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import { regionData,CodeToText  } from 'element-china-area-data'
    export default {

        name: 'baseTable',
        data() {
            return {
                allAddressInfo: regionData,
                allOccupationType: [{"value":1001,"label":"IT服务","children":[{"value":1001000,"label":"计算机软件/硬件/信息服务"},{"value":1001001,"label":"互联网和相关服务"},{"value":1001002,"label":"其他"}],"icon":""},{"value":1002,"label":"制造业","children":[{"value":1002000,"label":"机械/电子"},{"value":1003000,"label":"服装/纺织"},{"value":1002002,"label":"汽车"},{"value":1002005,"label":"金属制品"},{"value":1003002,"label":"食品/饮料"},{"value":1003003,"label":"家具/家纺"},{"value":1002001,"label":"重工制造"},{"value":1003005,"label":"家电/数码"},{"value":1002004,"label":"橡胶/塑料"},{"value":1003004,"label":"日用品/化妆品"},{"value":1002006,"label":"化学原料制品"},{"value":1003007,"label":"文教/工美/体育/娱乐用品"},{"value":1003006,"label":"烟酒/茶"},{"value":1002007,"label":"非金属矿物"},{"value":1002003,"label":"其他"}],"icon":""},{"value":1003,"label":"批发/零售","children":[{"value":1003008,"label":"批发"},{"value":1003010,"label":"零售"},{"value":1003001,"label":"超市/便利店/百货商场"},{"value":1003011,"label":"进出口"},{"value":1003009,"label":"其他"}],"icon":""},{"value":1004,"label":"生活服务","children":[{"value":1004001,"label":"餐饮"},{"value":1004004,"label":"居民服务"},{"value":1004002,"label":"租赁和商务服务"},{"value":1004000,"label":"酒店/住宿"},{"value":1004003,"label":"其他"}],"icon":""},{"value":1005,"label":"文化/体育/娱乐业","children":[{"value":1005001,"label":"文化/体育"},{"value":1005002,"label":"娱乐/旅游"},{"value":1005000,"label":"新闻传媒"},{"value":1005003,"label":"其他"}],"icon":""},{"value":1006,"label":"建筑/房地产","children":[{"value":1006001,"label":"建筑业"},{"value":1006002,"label":"建材装修"},{"value":1006000,"label":"房地产"},{"value":1006003,"label":"其他"}],"icon":""},{"value":1007,"label":"教育","children":[{"value":1007000,"label":"学前教育","desc":"如：托儿所、幼儿园"},{"value":1007001,"label":"初中等教育","desc":"如：小学、初中、高中、职高"},{"value":1007002,"label":"高等教育","desc":"如：大学、高职、高专"},{"value":1007003,"label":"培训机构"},{"value":1007004,"label":"其他"}],"icon":""},{"value":1008,"label":"运输/物流/仓储","children":[{"value":1008003,"label":"物流/仓储"},{"value":1008000,"label":"道路/铁路运输"},{"value":1008004,"label":"邮政/快递"},{"value":1008001,"label":"航空运输"},{"value":1008002,"label":"水上运输"},{"value":1008005,"label":"其他"}],"icon":""},{"value":1009,"label":"医疗","children":[{"value":1009000,"label":"医院/医疗机构"},{"value":1009003,"label":"医疗器械"},{"value":1009001,"label":"医药制造"},{"value":1009002,"label":"医药流通"},{"value":1009004,"label":"其他"}],"icon":""},{"value":1010,"label":"政府","children":[{"value":1010000,"label":"党政机关"},{"value":1010001,"label":"国家权力/行政机构"},{"value":1010002,"label":"检察院/法院/公安"},{"value":1010003,"label":"民政/人社/交通/卫生"},{"value":1010004,"label":"发改委/经信委/商务局/统计局"},{"value":1010005,"label":"国土/规划"},{"value":1010006,"label":"税务/海关/工商/环保/物价/药品"},{"value":1010007,"label":"政协/民主党派"},{"value":1010008,"label":"地方政府"},{"value":1010009,"label":"其他"}],"icon":""},{"value":1011,"label":"金融","children":[{"value":1011000,"label":"保险"},{"value":1011001,"label":"银行"},{"value":1011002,"label":"证券/投资/基金"},{"value":1011003,"label":"其他"}],"icon":""},{"value":1012,"label":"能源/采矿","children":[{"value":1014003,"label":"电力/热力/燃气/水供应业"},{"value":1012003,"label":"石油/天然气"},{"value":1012002,"label":"煤炭"},{"value":1012001,"label":"有色金属"},{"value":1012000,"label":"钢铁"},{"value":1012004,"label":"其他"}],"icon":""},{"value":1013,"label":"农林渔牧","children":[{"value":1013000,"label":"农林渔牧"}],"icon":""},{"value":1014,"label":"其他行业","children":[{"value":1014000,"label":"科学研究和技术服务业"},{"value":1014002,"label":"社会组织"},{"value":1014001,"label":"水利和环境管理"},{"value":1014004,"label":"国际组织"},{"value":1014005,"label":"其他"}],"icon":""}],
                allSex:[{value: 1,label: '男'}, {value: 2,label: '女'}, {value: 3,label: '未知'}],
                allEducation:[{value: 0,label: '无教育'},{value: 10,label: '小学毕业'},{value: 20,label: '初中毕业'},{value: 30,label: '高中毕业'},{value: 40,label: '专科'},{value: 50,label: '本科'},{value: 60,label: '硕士'},{value: 70,label: '博士'}],
                allMarried:[{value: false,label: '未婚'}, {value: true,label: '离异'}],
                allOnly:[{value: false,label: '是'}, {value: true,label: '否'}],
                allHouse:[{value: false,label: '无'}, {value: true,label: '有'}],
                allCar:[{value: false,label: '无'}, {value: true,label: '有'}],
                fileList:[],
                query: {
                    address: '',
                    name: '',
                    pageIndex: 1,
                    pageSize: 2,
                    liveAddress: regionData,
                    selectedLiveAddress:[]
                },
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                pageTotal: 0,
                form: {},
                idx: -1,
                id: -1,
                data: {
                    "list": [],
                    "pageTotal": 0
                }
            };
        },
        created() {
            this.getData();
        },
        methods: {
            // 获取 easy-mock 的模拟数据
            getData() {
                // fetchData(this.query).then(res => {
                //     console.log(res);
                //     this.tableData = res.list;
                //     this.pageTotal = res.pageTotal || 50;
                // });
                let self = this;
                let data = {
                    pageNum: self.query.pageIndex,
                    pageSize: self.query.pageSize,
                }
                self.$post("/base/user/qryAll", data).then(function (response) {
                    if (response.status == 0) {
                        self.tableData = response.obj.list;
                        self.pageTotal = response.obj.total;
                    }
                }).catch(function (err) {
                    console.log(err)
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
                        this.tableData.splice(index, 1);
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
            handleEdit(index, row) {
                this.idx = index;
                console.log(row)
                this.form = row;
                this.form.occupationType = [row.occupationTypeFirst,row.occupationTypeSecond]
                this.form.birthday = row.birthday;

                this.form.selectedLiveAddress = [];
                if (row.liveProvince != null && row.liveProvince != '') {
                    this.form.selectedLiveAddress.push(row.liveProvince);
                }
                if (row.liveCity != null && row.liveCity != '') {
                    this.form.selectedLiveAddress.push(row.liveCity);
                }
                if (row.liveCounty != null && row.liveCounty != '') {
                    this.form.selectedLiveAddress.push(row.liveCounty);
                }

                this.form.selectedWorkAddress = [];
                if (row.workProvince != null && row.workProvince != '') {
                    this.form.selectedWorkAddress.push(row.workProvince);
                }
                if (row.workCity != null && row.workCity != '') {
                    this.form.selectedWorkAddress.push(row.workCity);
                }
                if (row.workCounty != null && row.workCounty != '') {
                    this.form.selectedWorkAddress.push(row.workCounty);
                }
                this.editVisible = true;
            },
            // 保存编辑
            saveEdit() {
                let self = this;

                // this.$message.success(`修改第 ${this.idx + 1} 行成功`);
                let editFileList = [];
                self.fileList.forEach((item, index) => {
                    if (item.status == "success") {
                        editFileList.push({
                            type: 1,
                            url: item.response.obj
                        })
                    }
                });
                let editForm = {
                    userId: self.form.userId,
                    userName: self.form.userName,
                    sex: self.form.sex,
                    height: self.form.height,
                    weight: self.form.weight,
                    birthday: self.form.birthday,
                    liveProvince: self.form.selectedLiveAddress[0] == null ? "" : self.form.selectedLiveAddress[0],
                    liveCity: self.form.selectedLiveAddress[1] == null ? "" : self.form.selectedLiveAddress[1],
                    liveCounty: self.form.selectedLiveAddress[2] == null ? "" : self.form.selectedLiveAddress[2],
                    liveAddress: self.form.liveAddress,
                    occupationTypeFirst: self.form.occupationType[0],
                    occupationTypeSecond: self.form.occupationType[1],
                    occupationMark: self.form.occupationMark,
                    workProvince: self.form.selectedWorkAddress[0] == null ? "" : self.form.selectedWorkAddress[0],
                    workCity: self.form.selectedWorkAddress[1] == null ? "" : self.form.selectedWorkAddress[1],
                    workCounty: self.form.selectedWorkAddress[2] == null ? "" : self.form.selectedWorkAddress[2],
                    workAddress: self.form.workAddress,
                    wechat: self.form.wechat,
                    qq: self.form.qq,
                    phone: self.form.phone,
                    salary: self.form.salary,
                    isMarried: self.form.isMarried,
                    marriedMark: self.form.marriedMark,
                    isOnly: self.form.isOnly,
                    onlyMark: self.form.onlyMark,
                    education: self.form.education,
                    educationInfo: self.form.educationInfo,
                    educationMark: self.form.educationMark,
                    desire: self.form.desire,
                    hasHouse: self.form.hasHouse,
                    houseMark: self.form.houseMark,
                    hasCar: self.form.hasCar,
                    carMark: self.form.carMark,
                    account: self.form.account,
                    email: self.form.email,
                    fileList: editFileList
                }

                self.$post("/base/user/edit", editForm).then(function (response) {
                    if (response.status == 0) {
                        self.form = {};
                        self.editVisible = false;
                        self.getData();
                        self.$message.success(`修改成功`);
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
            changeLiveAddress(value)  {
                console.log(value)
                console.log(regionData)
            },
            getDateStr(date) {
                 var year = date.getFullYear();
                var month =(date.getMonth() + 1).toString();
                var day = (date.getDate()).toString();
                return year+"-"+month+"-"+day
            },
            changeOccupationType(value) {
                console.log(value)
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
                this.fileList = fileList
            },
            handlePreview(file) {
                console.log(file);
            },
            uploadSuccess(response, file, fileList) {
                console.log(file)
                console.log(fileList)
                this.fileList = fileList
            }

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
