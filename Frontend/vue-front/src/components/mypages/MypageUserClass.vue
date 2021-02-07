<template>
  <div>
    <v-row o-gutters>
      <v-col cols="12">
        <v-simple-table dark fixed-header height="300px">
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-center">
                  클래스 이름
                </th>
                <th class="text-center">
                  날짜
                </th>
                <th class="text-center">
                  시간
                </th>
                <th class="text-center">
                  바로가기
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in classDataList" :key="item.name">
                <td class="text-center">{{ item.class_name }}</td>
                <td class="text-center">{{ item.class_date }}</td>
                <td class="text-center">
                  {{ item.class_starttime.slice(0, 5) }}
                </td>
                <td>
                  <v-btn
                    :to="'/class/detail/' + item.classcode"
                    class="ma-2"
                    color="black"
                    text="black"
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
import { MypageCustomerClass } from '@/api/mypage';

export default {
  data() {
    return {
      classDataList: [],
    };
  },
  async created() {
    const userid = this.$store.state.usercode;
    console.log(userid);
    const res = await MypageCustomerClass(1);
    this.classDataList = res.data;
  },
};
</script>

<style scoped>
.ma-2 {
  background-color: orange;
}
</style>
