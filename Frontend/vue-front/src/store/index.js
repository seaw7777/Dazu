import Vue from 'vue';
import Vuex from 'vuex';
import {
  getAuthFromCookie,
  getUserFromCookie,
  getImgFromCookie,
  getUserCodeFromCookie,
  getUserTypeFromCookie,
  getDongFromCookie,
  getStoreCodeFromCookie,
  saveAuthToCookie,
  saveUserToCookie,
  saveImgToCookie,
  saveUserCodeToCookie,
  saveUserTypeToCookie,
  saveDongToCookie,
  saveStoreCodeToCookie,
} from '@/utils/cookies';

Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    username: getUserFromCookie() || '',
    token: getAuthFromCookie() || '',
    userimg: getImgFromCookie() || '',
    code: '',
    address: '',
    usercode: getUserCodeFromCookie() || '',
    usertype: getUserTypeFromCookie() || '',
    dong: getDongFromCookie() || '',
    storecode: getStoreCodeFromCookie() || '',
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
    setAddress(state, address) {
      state.address = address;
    },
    setUserCode(state, usercode) {
      state.usercode = usercode;
    },
    setUserType(state, usertype) {
      state.type = usertype;
    },
    setDong(state, dong) {
      state.dong = dong;
    },
    setStoreCode(state, storecode) {
      state.storecode = storecode;
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
    clearUserCode(state) {
      state.usercode = '';
    },
    clearUserType(state) {
      state.usertype = '';
    },
    clearStoreCode(state) {
      state.storecode = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      console.log(userData.nickname);
      commit('setToken', userData.accessToken);
      commit('setUsername', userData.nickname);
      commit('setUserimg', userData.profileImage);
      commit('setUserCode', userData.usercode);
      commit('setUserType', userData.usertype);
      commit('setDong', userData.dong);
      saveAuthToCookie(userData.accessToken);
      saveUserToCookie(userData.nickname);
      saveImgToCookie(userData.profileImage);
      saveUserCodeToCookie(userData.usercode);
      saveUserTypeToCookie(userData.usertype);
      saveDongToCookie(userData.dong);
      return userData;
    },
    // async CODE({ commit }, codeData) {
    //   console.log(codeData);
    //   commit('setCode', codeData);
    //   return codeData;
    // },
    async ROAD({ commit }, address) {
      console.log(address);
      commit('setAddress', address);
      return address;
    },
    async EXTRAINFO({ commit }, extrainfo) {
      console.log('vuex' + extrainfo);
      commit('setUserType', extrainfo.usertype);
      commit('setDong', extrainfo.dong);
      saveUserTypeToCookie(extrainfo.usertype);
      saveDongToCookie(extrainfo.dong);
    },
    async STORECODE({ commit }, storeData) {
      commit('setStoreCode', storeData.storecode);
      saveStoreCodeToCookie(storeData.storecode);
    },
  },
});
