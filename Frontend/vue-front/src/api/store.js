import { instance } from './index';

function fetchStore(dong) {
  return instance.get(`store/list/${dong}`);
}
function updateStoreName(newName) {
  return instance.put('store/update/name', newName);
}
function updateStoreAddress(newAddress) {
  return instance.put('store/update/address', newAddress);
}

export { fetchStore, updateStoreName, updateStoreAddress };
