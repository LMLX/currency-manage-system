import router from './router'
import store from './store'
// import { Message } from 'element-ui'
const _import = require('./router/_import_dev') //获取组件的方法
import common from "./api/common"
import {post} from './api/service.js'
import user from "./store/modules/user";

let isOnce = true
// 使用钩子函数对路由进行权限跳转
router.beforeEach(async (to, from, next) => {


    document.title = `${to.meta.title} | vue-manage-system`;
    const userName = common.getLocalStorage('ms_username');
    if (to.path != '/login' && !userName) {  // !login !userName    next('/login')
        console.log(1)
        next('/login')
    } else {
        if (to.path == '/login' && userName) {  // login userName    next('/dashboard')
            console.log("login")
            if(isOnce) {
                await init()
                isOnce = false
            }
            console.log(2)
            next('/dashboard')
        } else {
            if (userName) { // !login userName     next();
                if(isOnce) {
                    await init()
                    isOnce = false
                    console.log(3)
                    next(to.path);
                }else {
                    console.log(4)
                    next();
                }
            } else { // login !userName   next();
                console.log(5)
                next();
            }
        }
    }
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
   try {
       console.log('init')
       // await post('/base/menu/queMenuByUserId', {
       //     "roleId": common.getLocalStorage("userInfo").roleId
       // }).then(response => {
       //     if (0 == response.status) {
       //         // 渲染菜单
       //         common.setLocalStorage('router', response.obj)
       //     }
       // })
       let menusMap = common.getLocalStorage('router')

       menusMap = filterAsyncRouter(menusMap)
       let b = [{
           path: '/',
           component: () => import(/* webpackChunkName: "home" */ './components/common/Home.vue'),
           meta: {title: '自述文件'},
           children:
               menusMap


       }]
       console.log(b)
       let a = [

           {
               path: '/',
               component: () => import(/* webpackChunkName: "home" */ './components/common/Home.vue'),
               meta: {title: '自述文件'},
               children: [
                   {
                       path: '/dashboard',
                       component: () => import(/* webpackChunkName: "dashboard" */ './components/page/Dashboard.vue'),
                       meta: { title: '系统首页' }
                   },
                   {
                       path: '/icon',
                       component: () => import(/* webpackChunkName: "icon" */ './components/page/Icon.vue'),
                       meta: { title: '自定义图标' }
                   },
                   {
                       path: '/table',
                       component: () => import(/* webpackChunkName: "table" */ './components/page/BaseTable.vue'),
                       meta: { title: '基础表格' }
                   },
                   {
                       path: '/tabs',
                       component: () => import(/* webpackChunkName: "tabs" */ './components/page/Tabs.vue'),
                       meta: { title: 'tab选项卡' }
                   },
                   {
                       path: '/form',
                       component: () => import(/* webpackChunkName: "form" */ './components/page/BaseForm.vue'),
                       meta: { title: '基本表单' }
                   },
                   {
                       // 富文本编辑器组件
                       path: '/editor',
                       component: () => import(/* webpackChunkName: "editor" */ './components/page/VueEditor.vue'),
                       meta: { title: '富文本编辑器' }
                   },
                   {
                       // markdown组件
                       path: '/markdown',
                       component: () => import(/* webpackChunkName: "markdown" */ './components/page/Markdown.vue'),
                       meta: { title: 'markdown编辑器' }
                   },
                   {
                       // 图片上传组件
                       path: '/upload',
                       component: () => import(/* webpackChunkName: "upload" */ './components/page/Upload.vue'),
                       meta: { title: '文件上传' }
                   },
                   {
                       // vue-schart组件
                       path: '/charts',
                       component: () => import(/* webpackChunkName: "chart" */ './components/page/BaseCharts.vue'),
                       meta: { title: 'schart图表' }
                   },
                   {
                       // 拖拽列表组件
                       path: '/drag',
                       component: () => import(/* webpackChunkName: "drag" */ './components/page/DragList.vue'),
                       meta: { title: '拖拽列表' }
                   },
                   {
                       // 拖拽Dialog组件
                       path: '/dialog',
                       component: () => import(/* webpackChunkName: "dragdialog" */ './components/page/DragDialog.vue'),
                       meta: { title: '拖拽弹框' }
                   },
                   {
                       // 国际化组件
                       path: '/i18n',
                       component: () => import(/* webpackChunkName: "i18n" */ './components/page/I18n.vue'),
                       meta: { title: '国际化' }
                   },
                   {
                       // 权限页面
                       path: '/permission',
                       component: () => import(/* webpackChunkName: "permission" */ './components/page/Permission.vue'),
                       meta: { title: '权限测试'}
                   },
                   {
                       path: '/404',
                       component: () => import(/* webpackChunkName: "404" */ './components/page/404.vue'),
                       meta: { title: '404' }
                   },
                   {
                       path: '/403',
                       component: () => import(/* webpackChunkName: "403" */ './components/page/403.vue'),
                       meta: { title: '403' }
                   }

               ]
           }
       ]
       console.log(a)
       router.options.routes = b;
       router.addRoutes(
           b
       )
   }catch (e) {
       console.log(e)
   }

}


function filterAsyncRouter(asyncRouterMap) { //遍历后台传来的路由字符串，转换为组件对象
    let arr = []
    const accessedRouters = asyncRouterMap.filter(route => {
        if (route.component) {
            console.log(route.component)
            route.component = _import(route.component)
            arr.push(route)
        }
        if (route.children && route.children.length) {
            arr = arr.concat(filterAsyncRouter(route.children))
        }
        return true
    })

    return arr
}
