import router from './router'
// import { Message } from 'element-ui'
const _import = require('./router/_import_dev') //获取组件的方法
import common from "./api/common"
import {post} from './api/service.js'

// 使用钩子函数对路由进行权限跳转
router.beforeEach(async (to, from, next) => {

    console.log(router)
    document.title = `${to.meta.title} | vue-manage-system`;
    const userName = common.getLocalStorage('ms_username');
    if (to.path != '/login' && !userName) {
        next('/login')
    } else {
        if (to.path == 'login' && userName) {
            next('/dashboard')
        } else {
            next();
        }
    }

    // let b = new Date().getTime();
    // console.log('话费 '+ (b - a))

    // if (to.path === '/login') {
    //
    //     console.log(1)
    //     next();
    //     // getRouter=[]
    // } else {
    //     //判断是否有用户
    //     console.log(common.getLocalStorage("userInfo"))
    //     if (common.getLocalStorage("userInfo")) {
    //
    //         await post('/base/menu/queMenuByUserId', {
    //             "roleId": common.getLocalStorage("userInfo").roleId
    //         }).then(response => {
    //             if (0 == response.status) {
    //                 // 渲染菜单
    //                 common.setLocalStorage('router', response.obj)
    //
    //                 // init(response.obj)
    //                 let a = [
    //                     {
    //                         path: '/',
    //                         redirect: '/dashboard'
    //                     },
    //                     {
    //                     path: '/',
    //                     component: () => import(/* webpackChunkName: "home" */ './components/common/Home.vue'),
    //                     meta: {title: '自述文件'},
    //                     children: [
    //
    //                         {
    //                             path: '/dashboard',
    //                             component: () => import(/* webpackChunkName: "dashboard" */ './components/page/Dashboard.vue'),
    //                             meta: {title: '系统首页'}
    //                         },
    //
    //                     ]
    //                 }]
    //                 router.options.routes = a;
    //                 router.addRoutes(
    //                     a
    //                 )
    //                 console.log(router)
    //
    //                 console.log(2)
    //                 next({...to, replace: true})
    //             } else {
    //
    //                 console.log(3)
    //                 next("login");
    //             }
    //         })
    //     } else {
    //
    //         console.log(4)
    //         next("login");
    //     }
    // }

});


// const role = common.getLocalStorage('ms_username');
// console.log(role)
// if (!role && to.path !== '/login') {
//     next('/login');
// } else if (to.meta.permission) {
//     // 如果是管理员权限则可进入，这里只是简单的模拟管理员权限而已
//     role === 'admin' ? next() : next('/403');
// } else {
//     // 简单的判断IE10及以下不进入富文本编辑器，该组件不兼容
//     if (navigator.userAgent.indexOf('MSIE') > -1 && to.path === '/editor') {
//         Vue.prototype.$alert('vue-quill-editor组件不兼容IE10及以下浏览器，请使用更高版本的浏览器查看', '浏览器不兼容通知', {
//             confirmButtonText: '确定'
//         });
//     } else {
//         next();
//     }
// }

// router.beforeEach((to, from, next) => {
//     let self = this
//     console.log(getRouter)
//     if (!getRouter) { //不加这个判断，路由会陷入死循环
//         if (!common.getLocalStorage('router')) {
//             // easy-mock官网经常挂掉，所以就不请求了,你们可以替换成自己公司的接口去请求,把下方的axios请求打开即可
// //             // axios.get('https://www.easy-mock.com/mock/5a5da330d9b48c260cb42ca8/example/antrouter').then(res => {
// //
// //             console.log('beforeEach  getRouter')
//             // getRouter = fakeRouter.router //假装模拟后台请求得到的路由数据
//             // saveObjArr('router', getRouter) //存储路由到localStorage
//             //
//             // routerGo(to, next) //执行路由跳转方法
//             // })
//
//             //渲染菜单
//             post('/base/menu/queMenuByUserId', {
//                 "roleId": common.getLocalStorage("userInfo").roleId
//             }).then(response => {
//                 if (0 == response.status) {
//                     getRouter = response.obj
//                     common.setLocalStorage('router', getRouter)
//                     routerGo(to, next) //执行路由跳转方法
//                 }
//             })
//         } else { //从localStorage拿到了路由
//             getRouter = common.getLocalStorage('router') //拿到路由
//             routerGo(to, next)
//         }
//     } else {
//         next()
//     }
//
// })

export async function init() {
    await post('/base/menu/queMenuByUserId', {
        "roleId": common.getLocalStorage("userInfo").roleId
    }).then(response => {
        if (0 == response.status) {
            // 渲染菜单
            common.setLocalStorage('router', response.obj)
        }
    })
    //
    let a = [
        {
            path: '/',
            redirect: '/dashboard'
        },
        {
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ './components/common/Home.vue'),
            meta: {title: '自述文件'},
            children: [

                {
                    path: '/dashboard',
                    component: () => import(/* webpackChunkName: "dashboard" */ './components/page/Dashboard.vue'),
                    meta: {title: '系统首页'}
                },

            ]
        }]
    router.options.routes = a;
    router.addRoutes(
        a
    )
    // let self = this
    // console.log("11");
    //
    //
    //
    //
    // console.log(global.antRouter);
    // let a = filterAsyncRouter(routes);
    // console.log(a)


}

function filterAsyncRouter(asyncRouterMap) { //遍历后台传来的路由字符串，转换为组件对象
    const accessedRouters = asyncRouterMap.filter(route => {
        if (route.component) {
            route.component = _import(route.component)
        }
        if (route.children && route.children.length) {
            route.children = filterAsyncRouter(route.children)
        }
        return true
    })

    return accessedRouters
}
