import Vue from 'vue'
import Router from 'vue-router'
import global from './../components/common/global'//全局
Vue.use(Router)
const originalPush = Router.prototype.push

Router.prototype.push = function push (location) {

    return originalPush.call(this, location).catch(function (err) {
    })

}
export const constantRoutes = [
    {
        path: '/',
        redirect: '/dashboard'
    },
    {
        path: '/login',
        component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
        meta: {title: '登录'}
    },
    // {
    //     path: '/',
    //     component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
    //     redirect: '/dashboard',
    //     meta: {title: '自述文件'},
    //     children: [
    //         {
    //             path: 'dashboard',
    //             component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Dashboard.vue'),
    //             meta: {title: '系统首页'}
    //         },
    //
    //     ]
    // }
]
const createRouter = () => new Router({
    routes: constantRoutes
})

const router = createRouter();
export default router
