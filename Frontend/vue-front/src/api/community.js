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
function getBestFamousStore() {
  return instance.get('Restaurants_board/Popular_posts');
}
function getFamousStoreList(map) {
  return instance.get(`Restaurants_board/list?map=${map}`);
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
};
