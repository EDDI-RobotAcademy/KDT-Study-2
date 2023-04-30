<template lang="">
    <div>
        <h2>상품 게시판</h2>
        <board-read-form v-if="products" :product="products"/>
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
        ProductId: {
            type: String,
            required: true,
        },
    },
    computed: {
        ...mapState(productModule, ['product'])
    },
    methods: {
        ...mapActions(
            productModule, ['requestproductToSpring', 'requestDeleteproductToSpring']
        ),

        async onDelete() {
        await this.requestProductToSpring(this.productId)
        await this.$router.push({ name: 'ProductListPage' })
        
        }
    },

    created() {

        this.requestproductToSpring(this.productId)
    }
}
</script>
<style lang="">
    
</style>