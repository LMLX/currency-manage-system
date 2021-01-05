import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from 'element-ui';
import VueI18n from 'vue-i18n';
import { messages } from './components/common/i18n';
import { Message } from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
// import './assets/css/theme-green/index.css'; // 浅绿色主题
import './assets/css/icon.css';
import './components/common/directives';
import 'babel-polyfill';
import md5 from 'js-md5';
import common from './api/common'
import {post, get} from './api/service.js'
import './promission'//这里进行路由后台获取的模拟
import global from './components/common/global'//全局
Vue.prototype.$global = global;
Vue.config.productionTip = false;
Vue.use(VueI18n);
Vue.use(ElementUI, {
  size: 'small'
});
const i18n = new VueI18n({
  locale: 'zh',
  messages
});
Vue.prototype.$md5 = md5;
Vue.prototype.$post = post
Vue.prototype.$get = get
Vue.prototype.$message = Message;
Vue.prototype.common = common;



new Vue({
  router,
  i18n,
  render: h => h(App)
}).$mount('#app');
