import Vue from 'vue';
import App from './App.vue';
import router from '@/routes/index';
import vuetify from './plugins/vuetify';
// import BootstrapVue from 'bootstrap-vue';
import store from '@/store/index';
import axios from 'axios';
import VCalendar from 'v-calendar';
import VueDaumPostcode from 'vue-daum-postcode';
// import './src/sass/main.scss';

import '@/assets/css/bootstrap.min.css';
import '@/assets/sass/_product.scss';

// import 'bootstrap/dist/css/bootstrap.css';
// import 'bootstrap-vue/dist/bootstrap-vue.css';
Vue.config.productionTip = false;
Vue.prototype.$axios = axios;

// Vue.use(BootstrapVue);
Vue.use(VueDaumPostcode);
Vue.use(VCalendar, {
  componentPrefix: 'vc',
});
new Vue({
  render: h => h(App),
  vuetify,
  router,
  store,
}).$mount('#app');
