import axios from 'axios'
import common from '../api/common'
import router from '../router/index.js'

const service = axios.create({
    // process.env.NODE_ENV === 'development' 来判断是否开发环境
    // easy-mock服务挂了，暂时不使用了
    // baseURL: 'https://www.easy-mock.com/mock/592501a391470c0ac1fab128',
    // timeout: 5000
});

// service.interceptors.request.use(
//     config => {
//         return config;
//     },
//     error => {
//         console.log(error);
//         return Promise.reject();
//     }
// );
// //
// service.interceptors.response.use(
//     response => {
//         if (response.status === 200) {
//             return response.data;
//         } else {
//             Promise.reject();
//         }
//     },
//     error => {
//         console.log(error);
//         return Promise.reject();
//     }
// );

// const post = function(url, data = {}) {
//     return new Promise((resolve, reject) => {
//         data.token = common.getLocalStorage("userInfo").token
//         axios.post(url, data)
//             .then(response => {
//                 resolve(response.data);
//             }, err => {
//                 reject(err)
//             })
//     })
// }
//
// export default {
//     post
//
// }

service.interceptors.request.use(
    config => {
        if(!common.getLocalStorage('token')){
            common.setLocalStorage('token','')
        }
        if(common.getLocalStorage("userInfo")) {
            config.headers.userId = common.getLocalStorage("userInfo").userId;
        }
        config.headers.Authorization = common.getLocalStorage("token");
        return config;
    },
    err => {
        return Promise.reject(err);
    }
);
service.interceptors.response.use(
    response => {
        if (response && response.status === 200) {
            if(response.data.status === 1 && response.data.msg === 'token过期'){
                console.log('login')
                common.delAllLocalStorage()
                router.push({path:'/login'});

            }
            return response.data
        } else {
            return Promise.reject(response.data.msg)
        }
    },
    error => {
        return Promise.reject(error)
    }
)

export default service
