<template>
  <div>
    <div class="cart__discount">
      <h6>Store Name</h6>
      <form>
        <input
          type="text"
          placeholder="Coupon code"
          v-model="storeData.store_name"
          readonly
        />
        <v-dialog v-model="dialog" persistent max-width="290">
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              style="font-size: 14px;color: #ffffff;font-weight: 700;letter-spacing: 2px;text-transform: uppercase;background: #111111;padding: 0 30px;border: none;position: absolute;right: 0;top: 0;height: 100%;"
              dark
              tile
              v-bind="attrs"
              v-on="on"
              @click="changeName(storeData)"
            >
              편집
            </v-btn>
          </template>
          <v-card>
            <v-card-title class="headline">
              가게 이름 편집
            </v-card-title>
            <v-card-text
              ><v-text-field
                v-model.trim="newStoreName"
                label="이름바꾸자"
                clearable
              ></v-text-field
            ></v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn text @click="putStoreName()">
                SAVE
              </v-btn>
              <v-btn text @click="dialog = false">
                CLOSE
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </form>
    </div>
  </div>
</template>

<script>
import { updateStoreName } from '@/api/store';
export default {
  data() {
    return {
      dialog: false,
      newStoreName: this.storeData.store_name,
      id: Number,
    };
  },
  props: {
    storeData: Object,
  },
  created() {
    this.newStoreName = this.storeData.store_name;
  },
  computed: {
    newName: function() {
      console.log(this.storeName);
      return this.newStoreName;
    },
  },
  methods: {
    changeName(data) {
      this.newStoreName = data.store_name;
    },
    changeDialog() {
      this.dialog = false;
    },
    async putStoreName() {
      this.id = this.storeData.storecode;
      await updateStoreName({
        dong: '',
        lat: '',
        lng: '',
        member_usercode: '',
        store_describe: '',
        store_grade: '',
        store_grade_cnt: '',
        store_location: '',
        store_name: this.newStoreName,
        storecode: this.id,
      });
      this.changeDialog();
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>

<style></style>
