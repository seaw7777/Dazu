import { instance } from './index';

// 행정동별 밀키트 목록을 읽어온다.
function fetchMealkits(dong) {
  return instance.get(`mealkit/list/${dong}`);
}
// 새로운 밀키트 정보를 등록한다.
function postMealkits(data) {
  return instance.post('mealkit/insert', data);
}
// 밀키트 정보를 삭제한다.
function deleteMealkits(code) {
  return instance.delete(`mealkit/delete/${code}`);
}
// 밀키트 정보를 수정한다.
function updateMealkits(data) {
  return instance.put('mealkit/update', data);
}
// 특정 클래스의 밀키트 정보를 읽어온다.
function fetchMealkit(classcode) {
  return instance.get(`mealkit/class/${classcode}`);
}

export {
  fetchMealkits,
  postMealkits,
  deleteMealkits,
  updateMealkits,
  fetchMealkit,
};
