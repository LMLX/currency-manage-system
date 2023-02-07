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
<!--                <el-cascader :options="query.liveAddress" v-model="query.selectedLiveAddress" @change="changeLiveAddress">-->
<!--                </el-cascader>-->
<!--                搜索-->
                <el-form ref="form" :model="form" label-width="70px" :inline="true">
                    <el-row :gutter="20">

                        <el-form-item label="姓名" >
                            <el-input style="width:120px" v-model="query.userName" placeholder="用户名" clearable></el-input>
                        </el-form-item>

                        <el-form-item label="身高">
                            <el-input-number v-model="query.heightLow"  controls-position="right"></el-input-number>
                            至
                            <el-input-number v-model="query.heightHigh" controls-position="right"></el-input-number>
                        </el-form-item>

                        <el-form-item label="居住地址"  style="margin-left: 35px;">
                            <!-- <el-input v-model="form.height"></el-input> -->
                            <el-cascader clearable style="width:120px" :options="queryAllAddressInfo" v-model="query.selectedLiveAddress" @change="changeLiveAddress">
                            </el-cascader>
                        </el-form-item>
                        <el-form-item label="出生年份" >
<!--                            <el-date-picker clearable-->
<!--                                v-model="query.birthday"-->
<!--                                type="monthrange"-->
<!--                                range-separator="至"-->
<!--                                start-placeholder="开始月份"-->
<!--                                end-placeholder="结束月份">-->
<!--                            </el-date-picker>-->
                            <el-input-number v-model="query.birthdayLow" controls-position="right" ></el-input-number>
                            至
<!--                            <el-input  v-model="query.birthdayHigh" controls-position="right"></el-input-number>-->
                                <el-input-number v-model="query.birthdayHigh" controls-position="right" ></el-input-number>
                        </el-form-item>

                    </el-row>
                    <el-row :gutter="20">
                        <el-form-item label="性别" >
                            <el-select clearable style="width:120px" v-model="query.sex">
                                <el-option
                                    v-for="item in allSex"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>

                        <el-form-item label="体重">
                            <el-input-number v-model="query.weightLow"  controls-position="right"></el-input-number>
                            至
                            <el-input-number v-model="query.weightHigh"  controls-position="right"></el-input-number>
                        </el-form-item>



                        <el-form-item clearable label="工作地址" style="margin-left: 35px;">
                            <el-cascader style="width:120px" :options="queryAllAddressInfo" v-model="query.selectedWorkAddress" @change="changeLiveAddress">
                            </el-cascader>
                        </el-form-item>
                        <el-form-item label="年薪" >
                            <el-input-number v-model="query.salaryLow"  controls-position="right"></el-input-number>
                            至
                            <el-input-number v-model="query.salaryHigh"  controls-position="right"></el-input-number>
                        </el-form-item>


                    </el-row>



                    <el-row  :gutter="20">

                        <el-form-item label="学历">
                            <!-- <el-input v-model="form.isMarried"></el-input> -->
                            <el-select clearable style="width:120px" v-model="query.education" placeholder="请选择">
                                <el-option
                                    v-for="item in allEducation"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>

                        <el-form-item label="婚姻">
                            <!-- <el-input v-model="form.isMarried"></el-input> -->
                            <el-select clearable style="width:120px" v-model="query.isMarried" placeholder="请选择">
                                <el-option
                                    v-for="item in allMarried"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>

                        <el-form-item label="房" >
                            <el-select clearable style="width:120px" v-model="query.hasHouse" placeholder="请选择">
                                <el-option
                                    v-for="item in allHouse"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="车" >
                            <el-select clearable style="width:120px" v-model="query.hasCar" placeholder="请选择">
                                <el-option
                                    v-for="item in allCar"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>

                        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                        <el-button type="primary" icon="el-icon-search" @click="handleAdd">添加</el-button>

                    </el-row>


                </el-form>
            </div>
<!--            表头-->
            <el-table
                :data="tableData"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange" style="width: 100%"
            >
                <el-table-column width="80" fixed prop="account" label="编号"></el-table-column>
                <el-table-column width="80" fixed prop="userName" label="姓名"></el-table-column>
                <el-table-column width="50" prop="sex" label="性别">
                    <template slot-scope="scope">
                        {{scope.row.sex == 1 ? "男" : scope.row.sex == 2 ? "女" : "未知"}}
                    </template>
                </el-table-column>
<!--                <el-table-column width="100" label="头像" align="center">-->
<!--                    <template slot-scope="scope">-->
<!--                        <el-image-->
<!--                            class="table-td-thumb"-->
<!--                            :src="scope.row.fileList.length === 0 ? '' : scope.row.fileList[0].url"-->
<!--                            :preview-src-list="scope.row.fileList"-->
<!--                        ></el-image>-->
<!--                    </template>-->
<!--                </el-table-column>-->
                <el-table-column width="80" prop="height" label="身高(cm)"></el-table-column>
                <el-table-column width="80" prop="weight" label="体重(斤)"></el-table-column>
                <el-table-column width="110" prop="age" label="年龄(周岁)"></el-table-column>
                <el-table-column width="100" prop="birthday" label="生日"></el-table-column>
                <el-table-column width="200" prop="liveAddressInfo" label="居住地址" >
                        <template slot-scope="scope">
                            <el-tooltip class="item" effect="dark"  placement="left-">
                                <span>{{scope.row.liveAddressInfo}}</span>
                                <span slot="content">{{scope.row.liveAddressInfo}}</span>
                            </el-tooltip>

                    </template>
                </el-table-column>
                <el-table-column width="200" prop="workAddressInfo" label="工作地址"></el-table-column>
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
                        {{scope.row.isOnly ? "是":"否"}}
                    </template>
                </el-table-column>
                <el-table-column prop="mark" label="本人备注" show-overflow-tooltip>
                </el-table-column>
                <el-table-column width="400" prop="chooseMsg" label="择偶标准" show-overflow-tooltip>
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
                    :current-page="query.pageNum"
                    :page-sizes="[2, 10, 30]"
                    :page-size="query.pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="pageTotal">
                </el-pagination>
            </div>

        </div>

        <!-- 编辑弹出框 -->
        <el-dialog :title=mergeVisibleMsg :visible.sync="mergeVisible" width="700px" :close-on-click-modal="false">
            <el-form ref="form" :model="form" label-width="90px" :inline="true">
                <el-row>

                    <el-form-item label="姓名">
                        <el-input style="width:180px" v-model="form.userName"></el-input>
                    </el-form-item>
                    <el-form-item label="性别">
                        <el-select style="width:180px" v-model="form.sex" placeholder="请选择">
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
                        <el-input style="width:180px" v-model="form.height"></el-input>
                    </el-form-item>
                    <el-form-item label="体重">
                        <el-input style="width:180px" v-model="form.weight"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="电话">
                        <el-input style="width:180px" v-model="form.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="微信">
                        <el-input style="width:180px" v-model="form.wechat"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="出生年份">
                        <!-- <el-input v-model="form.birthday"></el-input> -->
                        <el-date-picker style="width:180px"
                        v-model="form.birthday"
                        type="year"
                        value-format="yyyy"
                        placeholder="选择年份">
                        </el-date-picker>
                    </el-form-item>
                    <el-form-item label="年龄">
                        <el-input style="width:180px" v-model="form.age" :disabled="true"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="居住地址">
                    <!-- <el-input v-model="form.height"></el-input> -->
                        <el-cascader style="width:180px" :options="queryAllAddressInfo" v-model="form.selectedLiveAddress" @change="changeLiveAddress">
                        </el-cascader>
                    </el-form-item>
                    <el-form-item label="详情地址">
                         <el-input style="width:180px" v-model="form.liveAddress"></el-input>
                    </el-form-item>

                </el-row>
                <el-row>
                    <el-form-item label="工作地址">
                        <el-cascader style="width:180px" :options="queryAllAddressInfo" v-model="form.selectedWorkAddress" @change="changeLiveAddress">
                        </el-cascader>
                    </el-form-item>
                    <el-form-item label="详情地址">
                        <el-input style="width:180px" v-model="form.workAddress"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="职业">
                        <!-- <el-input v-model="form.occupationType"></el-input> -->
                        <el-cascader style="width:180px"
                        v-model="form.occupationType"
                        :options="allOccupationType"
                        @change="changeOccupationType">
                        </el-cascader>
                    </el-form-item>
                    <el-form-item label="职业备注">
                        <el-input style="width:180px" v-model="form.occupationMark"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="年薪">
                        <el-input style="width:180px" v-model="form.salary"></el-input>
                    </el-form-item>
                    <el-form-item label="生肖">
                        <el-input style="width:180px" v-model="form.zodiac" :disabled="true"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="学历">
                        <!-- <el-input v-model="form.education"></el-input> -->
                        <el-select style="width:180px" v-model="form.education" placeholder="请选择">
                            <el-option
                            v-for="item in allEducation"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="学历备注">
                        <el-input style="width:180px" v-model="form.educationMark"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="婚姻情况">
                        <!-- <el-input v-model="form.isMarried"></el-input> -->
                        <el-select style="width:180px" v-model="form.isMarried" placeholder="请选择">
                            <el-option
                            v-for="item in allMarried"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="婚姻备注">
                        <el-input style="width:180px" v-model="form.marriedMark"></el-input>
                    </el-form-item>
                </el-row>
                    <el-form-item label="独生子女">
                        <el-select style="width:180px" v-model="form.isOnly" placeholder="请选择">
                            <el-option
                            v-for="item in allOnly"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="家庭备注">
                        <el-input style="width:180px" v-model="form.onlyMark"></el-input>
                    </el-form-item>
                <el-row>
                    <el-form-item label="房情况">
                        <el-select style="width:180px" v-model="form.hasHouse" placeholder="请选择">
                            <el-option
                            v-for="item in allHouse"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="房情况备注">
                        <el-input style="width:180px" v-model="form.houseMark"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="车情况">
                        <el-select style="width:180px" v-model="form.hasCar" placeholder="请选择">
                            <el-option
                            v-for="item in allCar"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="车情况备注">
                        <el-input style="width:180px" v-model="form.carMark"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="编号">
                        <el-input style="width:180px" v-model="form.account"></el-input>
                    </el-form-item>

                </el-row>
                <el-row>
                    <el-form-item label="本人备注">
                        <el-input type="textarea" style="width:450px" v-model="form.mark"></el-input>
                    </el-form-item>

                </el-row>
                <el-row>
                    <el-form-item label="择偶标准">
                        <el-input type="textarea" style="width:450px" v-model="form.chooseMsg"></el-input>
                    </el-form-item>

                </el-row>
<!--                <el-row>-->
<!--                    <el-form-item label="照片">-->
<!--                        <el-upload-->
<!--                            class="upload-demo"-->
<!--                            action="http://localhost:8081/base/user/upload"-->
<!--                            :on-preview="handlePreview"-->
<!--                            :file-list="form.fileList"-->
<!--                            :on-success="uploadSuccess"-->
<!--                            list-type="picture-card">-->
<!--                            <i slot="default" class="el-icon-plus"></i>-->
<!--                            <div slot="file" slot-scope="{file}">-->
<!--                                <img-->
<!--                                    class="el-upload-list__item-thumbnail"-->
<!--                                    :src="file.url" alt=""-->
<!--                                >-->
<!--                                <span class="el-upload-list__item-actions">-->
<!--                                <span-->
<!--                                    class="el-upload-list__item-preview"-->
<!--                                    @click="handlePictureCardPreview(file)"-->
<!--                                >-->
<!--                                <i class="el-icon-zoom-in"></i>-->
<!--                                </span>-->
<!--                                <span-->
<!--                                    v-if="!dialogDisabled"-->
<!--                                    class="el-upload-list__item-delete"-->
<!--                                    @click="handleRemove(file)"-->
<!--                                >-->
<!--                                <i class="el-icon-delete"></i>-->
<!--                                </span>-->
<!--                            </span>-->
<!--                            </div>-->
<!--                        </el-upload>-->

<!--                    </el-form-item>-->
<!--                </el-row>-->

            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="mergeVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>
        <el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false">
                            <img width="100%" :src="dialogImageUrl" alt="">
                        </el-dialog>
    </div>
</template>

<script>
    import { regionData,regionDataPlus,CodeToText } from 'element-china-area-data'
    export default {

        name: 'baseTable',
        data() {
            return {
                dialogImageUrl: '',
                dialogVisible: false,
                dialogDisabled: false,
                allAddressInfo: regionData,
                queryAllAddressInfo: regionDataPlus,
                allOccupationType: [{"value":1001,"label":"IT服务","children":[{"value":1001000,"label":"计算机软件/硬件/信息服务"},{"value":1001001,"label":"互联网和相关服务"},{"value":1001002,"label":"其他"}],"icon":""},{"value":1002,"label":"制造业","children":[{"value":1002000,"label":"机械/电子"},{"value":1003000,"label":"服装/纺织"},{"value":1002002,"label":"汽车"},{"value":1002005,"label":"金属制品"},{"value":1003002,"label":"食品/饮料"},{"value":1003003,"label":"家具/家纺"},{"value":1002001,"label":"重工制造"},{"value":1003005,"label":"家电/数码"},{"value":1002004,"label":"橡胶/塑料"},{"value":1003004,"label":"日用品/化妆品"},{"value":1002006,"label":"化学原料制品"},{"value":1003007,"label":"文教/工美/体育/娱乐用品"},{"value":1003006,"label":"烟酒/茶"},{"value":1002007,"label":"非金属矿物"},{"value":1002003,"label":"其他"}],"icon":""},{"value":1003,"label":"批发/零售","children":[{"value":1003008,"label":"批发"},{"value":1003010,"label":"零售"},{"value":1003001,"label":"超市/便利店/百货商场"},{"value":1003011,"label":"进出口"},{"value":1003009,"label":"其他"}],"icon":""},{"value":1004,"label":"生活服务","children":[{"value":1004001,"label":"餐饮"},{"value":1004004,"label":"居民服务"},{"value":1004002,"label":"租赁和商务服务"},{"value":1004000,"label":"酒店/住宿"},{"value":1004003,"label":"其他"}],"icon":""},{"value":1005,"label":"文化/体育/娱乐业","children":[{"value":1005001,"label":"文化/体育"},{"value":1005002,"label":"娱乐/旅游"},{"value":1005000,"label":"新闻传媒"},{"value":1005003,"label":"其他"}],"icon":""},{"value":1006,"label":"建筑/房地产","children":[{"value":1006001,"label":"建筑业"},{"value":1006002,"label":"建材装修"},{"value":1006000,"label":"房地产"},{"value":1006003,"label":"其他"}],"icon":""},{"value":1007,"label":"教育","children":[{"value":1007000,"label":"学前教育","desc":"如：托儿所、幼儿园"},{"value":1007001,"label":"初中等教育","desc":"如：小学、初中、高中、职高"},{"value":1007002,"label":"高等教育","desc":"如：大学、高职、高专"},{"value":1007003,"label":"培训机构"},{"value":1007004,"label":"其他"}],"icon":""},{"value":1008,"label":"运输/物流/仓储","children":[{"value":1008003,"label":"物流/仓储"},{"value":1008000,"label":"道路/铁路运输"},{"value":1008004,"label":"邮政/快递"},{"value":1008001,"label":"航空运输"},{"value":1008002,"label":"水上运输"},{"value":1008005,"label":"其他"}],"icon":""},{"value":1009,"label":"医疗","children":[{"value":1009000,"label":"医院/医疗机构"},{"value":1009003,"label":"医疗器械"},{"value":1009001,"label":"医药制造"},{"value":1009002,"label":"医药流通"},{"value":1009004,"label":"其他"}],"icon":""},{"value":1010,"label":"政府","children":[{"value":1010000,"label":"党政机关"},{"value":1010001,"label":"国家权力/行政机构"},{"value":1010002,"label":"检察院/法院/公安"},{"value":1010003,"label":"民政/人社/交通/卫生"},{"value":1010004,"label":"发改委/经信委/商务局/统计局"},{"value":1010005,"label":"国土/规划"},{"value":1010006,"label":"税务/海关/工商/环保/物价/药品"},{"value":1010007,"label":"政协/民主党派"},{"value":1010008,"label":"地方政府"},{"value":1010009,"label":"其他"}],"icon":""},{"value":1011,"label":"金融","children":[{"value":1011000,"label":"保险"},{"value":1011001,"label":"银行"},{"value":1011002,"label":"证券/投资/基金"},{"value":1011003,"label":"其他"}],"icon":""},{"value":1012,"label":"能源/采矿","children":[{"value":1014003,"label":"电力/热力/燃气/水供应业"},{"value":1012003,"label":"石油/天然气"},{"value":1012002,"label":"煤炭"},{"value":1012001,"label":"有色金属"},{"value":1012000,"label":"钢铁"},{"value":1012004,"label":"其他"}],"icon":""},{"value":1013,"label":"农林渔牧","children":[{"value":1013000,"label":"农林渔牧"}],"icon":""},{"value":1014,"label":"其他行业","children":[{"value":1014000,"label":"科学研究和技术服务业"},{"value":1014002,"label":"社会组织"},{"value":1014001,"label":"水利和环境管理"},{"value":1014004,"label":"国际组织"},{"value":1014005,"label":"其他"}],"icon":""}],
                allSex:[{value: 1,label: '男'}, {value: 2,label: '女'}, {value: 0,label: '未知'}],
                allEducation:[{value: 0,label: '无教育'},{value: 10,label: '小学毕业'},{value: 20,label: '初中毕业'},{value: 30,label: '高中毕业'},{value: 40,label: '专科'},{value: 50,label: '本科'},{value: 60,label: '硕士'},{value: 70,label: '博士'},{value: 80,label: '在编'}],
                allMarried:[{value: 0,label: '未婚'}, {value: 1,label: '离异'}, {value: 2,label: '短婚未孕'}],
                allOnly:[{value: false,label: '否'}, {value: true,label: '是'}],
                allHouse:[{value: false,label: '无'}, {value: true,label: '有'}],
                allCar:[{value: false,label: '无'}, {value: true,label: '有'}],
                query: {
                    pageNum: 1,
                    pageSize: 10,
                },
                tableData: [],
                multipleSelection: [],
                delList: [],
                mergeVisible: false,
                mergeVisibleMsg: "",
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
            let data = {
                pageNum: this.query.pageNum,
                pageSize: this.query.pageSize
            }
            this.getData(data);
        },
        methods: {
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },
            // 获取 easy-mock 的模拟数据
            getData(data) {
                // fetchData(this.query).then(res => {
                //     console.log(res);
                //     this.tableData = res.list;
                //     this.pageTotal = res.pageTotal || 50;
                // });
                let self = this;
                if (undefined != data.selectedLiveAddress) {
                    console.log("ooo")
                    data.liveProvince = data.selectedLiveAddress[0] == null ? "" : data.selectedLiveAddress[0];
                    data.liveCity = data.selectedLiveAddress[1] == null ? "" : data.selectedLiveAddress[1];
                    data.liveCounty = data.selectedLiveAddress[2] == null ? "" : data.selectedLiveAddress[2];
                }

                if (undefined != data.selectedWorkAddress) {
                    data.workProvince = data.selectedWorkAddress[0] == null ? "" : data.selectedWorkAddress[0];
                    data.workCity = data.selectedWorkAddress[1] == null ? "" : data.selectedWorkAddress[1];
                    data.workCounty = data.selectedWorkAddress[2] == null ? "" : data.selectedWorkAddress[2];
                }

                data.pageNum = self.query.pageNum;
                data.pageSize = self.query.pageSize;
                data.roleId = 2;

                console.log(data)
                self.$post("/base/user/qryAll", data).then(function (response) {
                    if (response.status == 0) {
                        self.tableData = response.obj.list;
                        self.pageTotal = response.obj.total;
                    }
                }).catch(function (err) {
                    self.$message.error(err.msg);
                })

            },
            // 触发搜索按钮
            handleSearch() {
                let self = this;
                self.query.pageNum = 1
                this.getData(self.query);
            },
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                let self = this;
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                        // this.$message.success('删除成功');
                        // console.log(row.userId)
                    self.$post("/base/user/delete", {
                        userId: row.userId
                    }).then(function (response) {
                        if (response.status == 0) {
                            self.getData(self.query);
                            self.$message.success(`删除成功`);
                        } else {
                            self.$message.error(response.msg);
                        }
                    }).catch(function (err) {
                        self.$message.error(err);
                    })
                }).catch((err) => {
                    self.$message.error(err);
                });
            },
            // 多选操作
            handleSelectionChange(val) {
                this.multipleSelection = val;
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
                this.mergeVisible = true;
                this.mergeVisibleMsg = "编辑";
            },
            handleAdd() {
                this.form = {
                    selectedLiveAddress: ["330000", "330500", "330502"],
                    selectedWorkAddress: ["330000", "330500", "330502"]
                };
                this.mergeVisible = true;
                this.mergeVisibleMsg = "保存";
            },
            // 保存编辑
            saveEdit() {
                let self = this;

                // this.$message.success(`修改第 ${this.idx + 1} 行成功`);
                let editFileList = [];
                if (null != self.form.fileList &&
                undefined != self.form.fileList
                && self.form.fileList.length > 0) {
                    self.form.fileList.forEach((item, index) => {
                        if (item.status == "success") {
                            if (null != item.response) {
                                editFileList.push({
                                    type: 1,
                                    url: item.response.obj
                                })
                            } else {
                                editFileList.push({
                                    type: 1,
                                    url: item.url
                                })
                            }
                        }
                    });
                }
                let liveProvince = null;
                let liveCity = null;
                let liveCounty = null;
                if (undefined != self.form.selectedLiveAddress) {
                    liveProvince = self.form.selectedLiveAddress[0] == null ? "" : self.form.selectedLiveAddress[0];
                    liveCity = self.form.selectedLiveAddress[1] == null ? "" : self.form.selectedLiveAddress[1];
                    liveCounty = self.form.selectedLiveAddress[2] == null ? "" : self.form.selectedLiveAddress[2];
                }

                let workProvince = null;
                let workCity = null;
                let workCounty = null;
                if (undefined != self.form.selectedWorkAddress) {
                    workProvince = self.form.selectedWorkAddress[0] == null ? "" : self.form.selectedWorkAddress[0];
                    workCity = self.form.selectedWorkAddress[1] == null ? "" : self.form.selectedWorkAddress[1];
                    workCounty = self.form.selectedWorkAddress[2] == null ? "" : self.form.selectedWorkAddress[2];
                }
                let occupationTypeFirst = null;
                let occupationTypeSecond = null;

                if (undefined != self.form.occupationType) {
                    occupationTypeFirst = self.form.occupationType[0];
                    occupationTypeSecond = self.form.occupationType[1];
                }
                let editForm = {
                    userId: self.form.userId,
                    userName: self.form.userName,
                    sex: self.form.sex,
                    height: self.form.height,
                    weight: self.form.weight,
                    birthday: self.form.birthday,
                    liveProvince: liveProvince,
                    liveCity: liveCity,
                    liveCounty: liveCounty,
                    liveAddress: self.form.liveAddress,
                    liveAddressInfo: self.getCodeToText(liveProvince, liveCity, liveCounty, self.form.liveAddress),
                    occupationTypeFirst: occupationTypeFirst,
                    occupationTypeSecond: occupationTypeSecond,
                    occupationMark: self.form.occupationMark,
                    workProvince: workProvince,
                    workCity: workCity,
                    workCounty: workCounty,
                    workAddress: self.form.workAddress,
                    workAddressInfo: self.getCodeToText(workProvince, workCity, workCounty, self.form.workAddress),
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
                    mark: self.form.mark,
                    chooseMsg: self.form.chooseMsg,
                    email: self.form.email,
                    fileList: editFileList
                }

                self.$post("/base/user/merge", editForm).then(function (response) {
                    if (response.status == 0) {
                        self.form = {};
                        self.mergeVisible = false;
                        self.getData(self.query);
                        self.$message.success(`修改成功`);
                    } else {
                        self.$message.error(response.msg);
                    }
                }).catch(function (err) {
                    self.$message.error(err);
                })
            },
            getCodeToText(province, city, county, address) {
                let area = "";
                if (null != province && undefined != province && "" != province) {
                    area += CodeToText[province] + "/";
                }
                if (null != city && undefined != city && "" != city ) {
                    area += CodeToText[city] + "/";
                }
                if (null != county && undefined != county && "" != county ) {
                    area += CodeToText[county] + "/";
                }
                if (null != address  && undefined != address && "" != address) {
                    area += address;
                }
                return area;
            },
            // 分页导航
            handlePageChange(val) {
                // console.log(111111)
                // this.$set(this.query, 'pageIndex', val);
                // this.getData(self.query);
                let self = this;
                self.query.pageNum = val
                this.getData(self.query)
            },
            handleSizeChange(val) {
                let self = this;
                this.query.pageSize = val
                this.getData(self.query)
            },
            changeLiveAddress(value)  {
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
            handleRemove(file) {
                let self = this;
                console.log(this.form.fileList)
                console.log(file);
                let newFileList = [];
                self.form.fileList.forEach((item, index) => {
                    if (item.uid != file.uid) {
                        newFileList.push(item);
                    }
                });
                this.form.fileList = newFileList;
            },
            handlePreview(file) {
                console.log(file);
            },
            uploadSuccess(response, file, fileList) {
                console.log(file)
                console.log(fileList)
                this.form.fileList = fileList
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
