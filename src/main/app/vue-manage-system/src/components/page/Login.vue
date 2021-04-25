<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">后台管理系统</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="username">
                    <el-input v-model="param.username" placeholder="username">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="password"
                        v-model="param.password"
                        @keyup.enter.native="submitForm()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                </div>
                <p class="login-tips">Tips : 用户名和密码随便填。</p>
            </el-form>
        </div>
    </div>
</template>

<script>
    import {init} from '../../promission'
    import axios from 'axios'
    export default {

        name: 'login',
        data: function () {
            return {
                param: {
                    username: 'admin',
                    password: 'admin',
                    position: '未知'
                },
                rules: {
                    username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
                    password: [{required: true, message: '请输入密码', trigger: 'blur'}],
                },
            };
        },
        methods: {
            submitForm() {
                let self = this;
                // axios.get("http://localhost:8101/park/model/camera-info/qryLRUCameraInfoTop")
                this.$refs.login.validate(async valid => {
                    if (valid) {
                        self.common.delAllLocalStorage()
                        self.param.position = await self.getLocation();
                        const data = {
                            'account': self.param.username,
                            'password': self.$md5(self.param.password),
                            'position': self.param.position
                        }
                        console.log(data)
                        self.$post('/base/user/checkLogin', data).then(async function (response) {
                            console.log(response)
                            if (0 === response.status) {
                                self.common.setLocalStorage("userInfo", response.obj)
                                self.common.setLocalStorage('ms_username', response.obj.userName);
                                self.common.setLocalStorage('token', response.obj.token);
                                await self.$post('/base/menu/qryMenuByUserId', {
                                    "roleId": self.common.getLocalStorage("userInfo").roleId
                                }).then(response => {
                                    if (0 === response.status) {
                                        // 渲染菜单
                                        self.common.setLocalStorage('router', response.obj)
                                    }
                                });

                                self.$router.push('/');
                            } else {
                                self.$message({
                                    type: 'error',
                                    message: response.msg,
                                    duration: 3000,
                                    showClose: true
                                });
                            }

                        })
                    } else {
                        self.$message.error('请输入账号和密码');
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            async getLocation() {
                let self = this
                let position = '未知'
                //调用百度api  ak可以自己去申请
                await self.$get('/baidu/location/ip?ak=k45Mt9SLKbrShWpcRSYPv1ldrXO5TqMn').then(function (response) {
                    console.log(response)
                    if (0 == response.status) {
                        console.log(response.content.address)
                        position = response.content.address
                    }
                    // self.p
                }).catch(err => {

                })
                return position;
            }
        },
    };
</script>

<style scoped>
    .login-wrap {
        position: relative;
        width: 100%;
        height: 100%;
        background-image: url(../../assets/img/login-bg.jpg);
        background-size: 100% 100%;
    }

    .ms-title {
        width: 100%;
        line-height: 50px;
        text-align: center;
        font-size: 20px;
        color: #fff;
        border-bottom: 1px solid #ddd;
    }

    .ms-login {
        position: absolute;
        left: 50%;
        top: 50%;
        width: 350px;
        margin: -190px 0 0 -175px;
        border-radius: 5px;
        background: rgba(255, 255, 255, 0.3);
        overflow: hidden;
    }

    .ms-content {
        padding: 30px 30px;
    }

    .login-btn {
        text-align: center;
    }

    .login-btn button {
        width: 100%;
        height: 36px;
        margin-bottom: 10px;
    }

    .login-tips {
        font-size: 12px;
        line-height: 30px;
        color: #fff;
    }
</style>
