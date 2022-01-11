import axios from 'axios';

const OrderContentsURL = "http://locaolhost:8081/ordercontents";

function orderContentsService {
    
    getAllOrderContents() {
        return axios.get(OrderContentsURL);
    }
}