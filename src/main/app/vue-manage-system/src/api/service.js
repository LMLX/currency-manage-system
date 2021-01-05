import service from '../utils/request.js'

// post请求
export async function post(url, data, configure) {
  return new Promise((resolve, reject) => {
    service.post(url, data, configure)
    .then(response => {
        resolve(response)
    }, err => {
        reject(err)
    })
    .catch((error) => {
        reject(error)
    })
  })
}

// post请求
export async function get(url) {
    return new Promise((resolve, reject) => {
        service.get(url)
            .then(response => {
                resolve(response)
            }, err => {
                reject(err)
            })
            .catch((error) => {
                reject(error)
            })
    })
}

// post请求
// export function postJson(url, data) {
//   var configure = {
//     headers: {
//       'Content-Type': 'application/json;charset=UTF-8'
//     }
//   }
//   var configF = { ...config, ...configure }
//   return new Promise((resolve, reject) => {
//     service.post(url, data, configF)
//     .then(response => {
//         resolve(response.data)
//     }, err => {
//         reject(err)
//     })
//     .catch((error) => {
//         reject(error)
//     })
//   })
// }
