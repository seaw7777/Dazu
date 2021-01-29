import Vue from 'vue';
import App from './App.vue';
import router from '@/routes/index';
import vuetify from './plugins/vuetify';
import BootstrapVue from 'bootstrap-vue';
import store from '@/store/index';
import axios from 'axios';

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
Vue.config.productionTip = false;
Vue.prototype.$axios = axios;

Vue.use(BootstrapVue);
new Vue({
  render: h => h(App),
  vuetify,
  router,
  store,
}).$mount('#app');
window.Kakao.init('a3024df033214c47f7043ddfeb10d1f3');
