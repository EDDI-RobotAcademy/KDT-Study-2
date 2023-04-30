<template lang="">
    <div>

        <h3 align="center">상품 목록</h3>

        <br>

        <product-register-form align="center" @submit="onSubmit"/>

        <br>
    </div>
</template>
<script>

import ProductRegisterForm from '@/components/product/ProductRegisterForm.vue';
// RegisterButtonForm 컴포넌트를 가져옴
import { mapActions } from 'vuex';
// vuex에서 mapActions 함수를 가져옴.

const productModule = 'productModule'

export default {
    components: {
        ProductRegisterForm
    },
    name: "ProductRegisterPage",
    methods: {
        ...mapActions(
            productModule, ['requestCreateProductToSpring']
        ),
        async onSubmit(payload) {
            const product = await this.requestCreateProductToSpring(payload)
            console.log('product: ' + JSON.stringify(product))

        }
    },


}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gothic+A1:wght@500&display=swap');

h3 {
    font-family: 'Black Hans Sans';
    font-size: 40px;
}
</style>