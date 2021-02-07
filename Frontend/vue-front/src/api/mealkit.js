import { instance } from './index';

function fetchMealkits(dong) {
  return instance.get(`mealkit/list/${dong}`);
}

export { fetchMealkits };
