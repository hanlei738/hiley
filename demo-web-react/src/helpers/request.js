import axios from 'axios'
import { ORIGIN } from '../constants'

const service = axios.create({
  baseURL: ORIGIN.development,
  timeout: 5000
})

const qs = require('qs')

service.interceptors.request.use(config => {
  config.headers['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8'
  if (config.data) {
    config.data = qs.stringify(config.data)
  }
  return config
}, error => {


  return Promise.reject(error);
})


service.interceptors.response.use(response => {
  return response.data
}, error => {
  return Promise.reject(error);
});

export default service;

// function requestGet(url, options = {}) {
//   return axios({
//     url: /^http/.test(url) ? url : `${ORIGIN}${url}`,
//     method: 'get',
//     // 携带cookie信息
//     withCredentials: true,
//     ...options,
//     data: options.body,
//   })
// }

// function requestPost(url, options = {}) {
//   return axios({
//     url: /^http/.test(url) ? url : `${ORIGIN}${url}`,
//     method: 'post',
//     // 携带cookie信息
//     withCredentials: true,
//     ...options,
//     data: options.body,
//   })
// }