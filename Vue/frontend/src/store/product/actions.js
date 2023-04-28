import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
    REQUEST_PRODUCT_TO_SPRING,
} from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
    requestProductListoSpring({ commit }) {
        return axiosInst.get('/product/list')
            .then((res) => {
                commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data)
            })
    },
    requestCreateProductToSpring({}, payload) {
        const { name, price, company, manufactureDate, category } = payload;

    return axiosInst
      .post("/product/register", {
        name,
        price,
        company,
        manufactureDate,
        category,
      })
      .then((res) => {
        alert("상품 등록 성공!");
        return res;
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
    requestDeleteProductToSpring ({}, productId) {
        return axiosInst.delete(`/jpa-product/${productId}`)
            .then((res) => {
                alert('삭제 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
  
};
