let antRouter = [

    // {
    //     path: '/dashboard',
    //     component: () => import(/* webpackChunkName: "dashboard" */ '../page/Dashboard.vue'),
    //     meta: { title: '系统首页' }
    // }
    {
        path: '/table',
        component: () => import(/* webpackChunkName: "dashboard" */ '../page/BaseTable.vue'),
        meta: { title: '基础表格' }
    }
]
export default {
    antRouter
}

