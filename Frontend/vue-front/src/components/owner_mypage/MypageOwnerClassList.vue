<template>
  <div>
    <v-row no-gutters>
      <v-col cols="12">
        <v-simple-table fixed-header height="200px">
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-center">
                  클래스 이름
                </th>
                <th class="text-center">
                  난이도
                </th>
                <th class="text-center">
                  음식 종류
                </th>
                <th class="text-center">
                  바로가기
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in classDataList" :key="item.name">
                <td class="text-center">{{ item.class_name }}</td>
                <td class="text-center">{{ item.class_difficult }}</td>
                <td class="text-center">
                  {{ item.food_type }}
                </td>
                <td>
                  <v-btn
                    :to="'/class/detail/' + item.classcode"
                    class="ma-2"
                    color="orange"
                    style="display: flex;"
                    >바로가기
                  </v-btn>
                </td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import { fetchStoreClassInfo } from '@/api/store';

export default {
  data() {
    return {
      classDataList: [],
    };
  },
  async created() {
    const storecode = this.$store.state.storecode;
    console.log(storecode);
    const res = await fetchStoreClassInfo(storecode);
    this.classDataList = res.data;
  },
};
</script>

<style></style>
