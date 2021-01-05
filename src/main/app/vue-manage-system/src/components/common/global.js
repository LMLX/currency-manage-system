let antRouter = [

    {
        path: '/dashboard',
        component: () => import(/* webpackChunkName: "dashboard" */ '../page/Dashboard.vue'),
        meta: { title: '系统首页' }
    }
]
export default {
    antRouter
}

