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
        name:'',
        redirect: '/dashboard'
    },
    {
        path: '/login',
        name:'login',
        component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
        meta: {title: '登录'}
    },
]
const createRouter = () => new Router({
    routes: constantRoutes
})

const router = createRouter();
export default router
