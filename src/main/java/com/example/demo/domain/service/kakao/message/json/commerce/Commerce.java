package com.example.demo.domain.service.kakao.message.json.commerce;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Commerce {
  private String productName;
  @NotBlank
  @Pattern(regexp = "^[0-9]+$", message = "regular_price 는 숫자만 입력가능합니다.")
  private String regularPrice;
  @Pattern(regexp = "^[0-9]+$", message = "discount_price 는 숫자만 입력가능합니다.")
  private String discountPrice;
  @Pattern(regexp = "^[0-9]+$", message = "discount_rate 는 숫자만 입력가능합니다.")
  private String discountRate;
  @Pattern(regexp = "^[0-9]+$", message = "fixedDiscountPrice 는 숫자만 입력가능합니다.")
  private String fixedDiscountPrice;
  private String currencyUnit;
  @Pattern(regexp = "^[0-9]+$", message = "currency_unit_position 는 숫자만 입력가능합니다.")
  private String currencyUnitPosition;
}
