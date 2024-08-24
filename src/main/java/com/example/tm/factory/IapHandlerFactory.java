package com.example.tm.factory;

import com.example.tm.handler.AbstractIapHandler;
import com.example.tm.purchase.IapSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/* 미리 정의한 iapHandler 중 적절한 Handler 를 찾아서 반환 */
@Component
@RequiredArgsConstructor
public class IapHandlerFactory {
    /* 만약 개수가 많아진 다면 캐싱 근데 그런 경우는 거의 없을 듯 */
    private final List<AbstractIapHandler> iapHandlers;

    public AbstractIapHandler findIapStore(IapSource iapSource) {
        return iapHandlers.stream()
                .filter(handler -> handler.isApplicable(iapSource))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("iapSource=" + iapSource.name() + " doesn't provide iap handler"));
    }
}
