import { instance } from './index';

function getBestTip() {
  return instance.get('tip_board/Popular_posts');
}
function getTipList(map) {
  return instance.get(`tip_board/list?map=${map}`);
}
function getBestFamousStore() {
  return instance.get('Restaurants_board/Popular_posts');
}
function getFamousStoreList(map) {
  return instance.get(`Restaurants_board/list?map=${map}`);
}

export { getBestTip, getTipList, getBestFamousStore, getFamousStoreList };
