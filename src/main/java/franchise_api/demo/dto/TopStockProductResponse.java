package franchise_api.demo.dto;

public record TopStockProductResponse(

        String branchName,
        String productName,
        Integer stock

) {
}