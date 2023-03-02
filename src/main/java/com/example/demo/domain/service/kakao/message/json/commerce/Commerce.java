package com.example.demo.domain.service.kakao.message.json.commerce;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Commerce {
  @JsonAlias({"productName","product_name"})
  private String productName;
  @NotBlank
  @Pattern(regexp = "^[0-9]+$", message = "regular_price 는 숫자만 입력가능합니다.")
  @JsonAlias({"regularPrice","regular_price"})
  private String regularPrice;
  @Pattern(regexp = "^[0-9]+$", message = "discount_price 는 숫자만 입력가능합니다.")
  @JsonAlias({"discountPrice","discount_price"})
  private String discountPrice;
  @Pattern(regexp = "^[0-9]+$", message = "discount_rate 는 숫자만 입력가능합니다.")
  @JsonAlias({"discountRate","discount_rate"})
  private String discountRate;
  @Pattern(regexp = "^[0-9]+$", message = "fixedDiscountPrice 는 숫자만 입력가능합니다.")
  @JsonAlias({"fixedDiscountPrice","fixed_discount_price"})
  private String fixedDiscountPrice;
  @JsonAlias({"currencyUnit","currency_unit"})
  private String currencyUnit;
  @Pattern(regexp = "^[0-9]+$", message = "currency_unit_position 는 숫자만 입력가능합니다.")
  @JsonAlias({"currencyUnitPosition","currency_unit_position"})
  private String currencyUnitPosition;
}
