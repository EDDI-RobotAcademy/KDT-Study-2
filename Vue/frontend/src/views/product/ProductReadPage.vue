<template lang="">
    <div>
        <h2>상품 게시판</h2>
        <product-read-form v-if="product" :product="product"/>
        <p v-else>로딩중 .......</p>
        <router-link :to="{ name: 'ProductModifyPage', params: { productId }}">
            게시물 수정
        </router-link> 
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'ProductListPage' }">
            돌아가기
        </router-link>
    </div>
</template>
<script>
import ProductReadForm from '@/components/product/ProductReadForm.vue'
import { mapActions, mapState } from 'vuex';
const productModule = 'productModule'
export default {
    components: {
        ProductReadForm
    },
    props: {
        productId: {
            type: String,
            required: true,
        },
    },
    computed: {
        ...mapState(productModule, ['product'])
    },
    methods: {
        ...mapActions(
            productModule, ['requestProductToSpring', 'requestDeleteProductToSpring']
        ),
        async onDelete() {
            await this.requestDeleteProductToSpring(this.productId)
            await this.$router.push({ name: 'ProductListPage' })
        }
    },
    created() {
        this.requestProductToSpring(this.productId)
    }
}
</script>
<style lang="">
    
</style>