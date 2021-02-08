import { instance } from './index';

function getBestTip() {
  return instance.get('tip_board/Popular_posts');
}
function getTipList(map) {
  return instance.get(`tip_board/list?map=${map}`);
}
function getTipDetail(board_code) {
  return instance.get(`tip_board/detail/${board_code}`);
}
function getTipDetailComment(board_code) {
  return instance.get(`tip_board_comment/list/${board_code}`);
}
function postTipComment(commentData) {
  return instance.post('tip_board_comment/write', commentData);
}
function postTip(tipData) {
  return instance.post('tip_board/write', tipData);
}
function updateTip(id) {
  return instance.get(`tip_board/modify/${id}`);
}
function putTip(tipData) {
  return instance.put('tip_board/modify', tipData);
}
function deleteTip(id) {
  return instance.delete(`tip_board/delete/${id}`);
}
function deleteTipComment(id) {
  return instance.delete(`tip_board_comment/delete/${id}`);
}
function getBestFamousStore() {
  return instance.get('Restaurants_board/Popular_posts');
}
function getFamousStoreList(map) {
  return instance.get(`Restaurants_board/list?map=${map}`);
}
function getFamousStoreDetail(board_code) {
  return instance.get(`Restaurants_board/detail/${board_code}`);
}
function getFamousStoreDetailComment(board_code) {
  return instance.get(`Restaurants_board_comment/list/${board_code}`);
}
function postFamousStoreComment(commentData) {
  return instance.post('Restaurants_board_comment/write', commentData);
}
function postFamousStore(tipData) {
  return instance.post('Restaurants_board/write', tipData);
}
function updateFamousStore(id) {
  return instance.get(`Restaurants_board/modify/${id}`);
}
function putFamousStore(tipData) {
  return instance.put('Restaurants_board/modify', tipData);
}
function deleteFamousStore(id) {
  return instance.delete(`Restaurants_board/delete/${id}`);
}
function deleteFamousStoreComment(id) {
  return instance.delete(`Restaurants_board_comment/delete/${id}`);
}

export {
  getBestTip,
  getTipList,
  getBestFamousStore,
  getFamousStoreList,
  getTipDetail,
  getTipDetailComment,
  postTipComment,
  postTip,
  updateTip,
  putTip,
  deleteTip,
  deleteTipComment,
  getFamousStoreDetail,
  getFamousStoreDetailComment,
  postFamousStoreComment,
  postFamousStore,
  updateFamousStore,
  putFamousStore,
  deleteFamousStore,
  deleteFamousStoreComment,
};
