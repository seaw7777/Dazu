<template>
  <div>
    <div class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <div class="breadcrumb__text">
              <h2>SignUp</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
    <OwnerStepForm></OwnerStepForm>
  </div>
</template>

<script>
import OwnerStepForm from '@/components/accounts/OwnerStepForm';

export default {
  components: {
    OwnerStepForm,
  },
};
</script>

<style></style>
