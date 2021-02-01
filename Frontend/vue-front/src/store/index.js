import Vue from 'vue';
import Vuex from 'vuex';
import {
  getAuthFromCookie,
  getUserFromCookie,
  getImgFromCookie,
  saveAuthToCookie,
  saveUserToCookie,
  saveImgToCookie,
} from '@/utils/cookies';
// import { loginUser } from '@/api/auth';

Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    username: getUserFromCookie() || '',
    token: getAuthFromCookie() || '',
    userimg: getImgFromCookie() || '',
    code: '',
  },
  getters: {
    isLogin(state) {
      return state.username !== '';
    },
  },
  mutations: {
    setUsername(state, username) {
      state.username = username;
    },
    setToken(state, token) {
      state.token = token;
    },
    setUserimg(state, userimg) {
      state.userimg = userimg;
    },

    clearUsername(state) {
      state.username = '';
    },
    clearToken(state) {
      state.token = '';
    },
    clearUserimg(state) {
      state.username = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      console.log(userData.nickname);
      commit('setToken', userData.accessToken);
      commit('setUsername', userData.nickname);
      commit('setUserimg', userData.profileImage);
      saveAuthToCookie(userData.accessToken);
      saveUserToCookie(userData.nickname);
      saveImgToCookie(userData.profileImage);
      return userData;
    },
    async CODE({ commit }, codeData) {
      console.log(codeData);
      commit('setCode', codeData);

      return codeData;
    },
  },
});
