<template>
    <div>
        <h2>상품 수정</h2>
        <product-modify-form v-if="product" :product="product" @submit="onSubmit" />

        <p>로딩중....</p>
    </div>
</template>
<script>
import ProductModifyForm from '@/components/product/ProductModifyForm.vue';
import { mapActions, mapState } from 'vuex';

const productModule = 'productModule'

export default {
    components: {
        ProductModifyForm
    },// ProductModifyForm 사용하겠습니다.
    props: {
        productId: {
            type: String,
            required: true,
        }

    },//productId를 받을 건데 required는 없으면 안된다는 뜻
    computed: {
        ...mapState(productModule, ['product'])

    },
    methods: {
        ...mapActions(
            productModule, ['requestProductToSpring', 'requestProductModifyToSpring']
        ),
        async onSubmit(payload) {
            const { name, price, company, expDate, manufactureDate, category } = payload
            //payload는 보낼 데이터임
            const productId = this.productId
            // 수정한 게시물의 id기때문에 this.사용
            await this.requestProductModifyToSpring({ name, price, company, expDate, manufactureDate, category, productId })
            await this.$router.push({//수정 요청이 보내져 작동한 후에 읽기 페이지를 푸시함
                name: 'ProductReadPage',
                params: { productId: this.productId }
            })
        }

    },
    //라이프 사이클 주기중 크리에이티드 시점에 작동하는 부분
    created() {
        this.requestProductToSpring(this.productId)
    }

}
</script>
<style lang="">
    
</style>