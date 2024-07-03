/*
package com.me.only.config.aop;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

*/
/**
 * @author Administrator
 *//*

@Aspect
@Component
public class RequestInterceptorAspect {

*/
/*    @Resource
    private CrmSearchContentRecordService contentRecordService;
    @Resource
    private TokenUtil tokenUtil;
    @Resource
    private CrmDictDataService crmDictDataService;*//*


    @Pointcut("@annotation(MemoryIntercept)")
    public void apiMethods(MemoryIntercept MemoryIntercept) {

    }

    */
/**
     * @param joinPoint
     * @param MemoryIntercept
     * @return
     *//*

    @After("apiMethods(MemoryIntercept)")
    public void afterAdvice(JoinPoint joinPoint, MemoryIntercept MemoryIntercept) {

        List<CrmDictData> crmDictData = crmDictDataService.queryListByType("crm_intercept_switch");
        CrmDictData crmDictData1 = crmDictData.get(0);
        if (BaseConstant.ZERO.toString().equals(crmDictData1.getDictValue())){
            return;
        }
        // 获取请求参数（这里只是示例，具体实现取决于你的应用上下文）
        String moduleType = MemoryIntercept.value();
        Object[] args = joinPoint.getArgs();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        if (args != null && args.length > 0) {
            List<CrmSearchContentRecord> crmSearchContentRecords = validateRequest(args, moduleType);
            if (CollectionUtils.isNotEmpty(crmSearchContentRecords)) {
                UserVo userVo = tokenUtil.getUserVo(request);
                contentRecordService.insertOrUpdateBatch(crmSearchContentRecords, userVo);
            }
        }
    }

    private List<CrmSearchContentRecord> validateRequest(Object[] args, String moduleType) {
        List<CrmSearchContentRecord> result = new ArrayList<>();

        // 通用的添加记录方法
        BiConsumer<Object, String> addRecordIfNotEmpty = (value, field) -> {
            if (ObjectUtils.isNotEmpty(value)) {
                result.add(setSearchContentRecord(value.toString(), moduleType, field));
            }
        };

        // 通用的添加集合记录方法
        BiConsumer<List<?>, String> addRecordIfCollectionNotEmpty = (collection, field) -> {
            if (CollectionUtils.isNotEmpty(collection)) {
                result.add(setSearchContentRecord(collection, moduleType, field));
            }
        };

        // 定义处理器映射
        Map<String, Consumer<Object[]>> handlers = new HashMap<>();
        handlers(addRecordIfNotEmpty, addRecordIfCollectionNotEmpty, handlers);
        // 调用处理器
        if (handlers.containsKey(moduleType)) {
            handlers.get(moduleType).accept(args);
        }

        return result;
    }

    private void handlers(BiConsumer<Object, String> addRecordIfNotEmpty, BiConsumer<List<?>, String> addRecordIfCollectionNotEmpty, Map<String, Consumer<Object[]>> handlers) {
        handlers.put(BaseConstant.SearchValue.APPOINTMENT, argsArr -> {
            AppointmentReqVO data = (AppointmentReqVO) argsArr[0];
            addRecordIfNotEmpty.accept(data.getDockingCustomerId(), "DockingCustomerId");
            addRecordIfCollectionNotEmpty.accept(data.getPromotionUserIds(), "promotionUserIds");
        });
        handlers.put(BaseConstant.SearchValue.APPOINTMENT_CREATE, argsArr -> {
            AppointmentVO data = (AppointmentVO) argsArr[0];
            addRecordIfNotEmpty.accept(data.getPromotionUserId(), "promotionUserId");
        });
        handlers.put(BaseConstant.SearchValue.APPOINTMENT_CHANGE, argsArr -> {
            AppointmentVO data = (AppointmentVO) argsArr[0];
            addRecordIfNotEmpty.accept(data.getPromotionUserId(), "promotionUserId");
        });
        handlers.put(BaseConstant.SearchValue.APPOINTMENT_REGISTER, argsArr -> {
            AppointmentReqVO data = (AppointmentReqVO) argsArr[0];
            addRecordIfNotEmpty.accept(data.getGoodsName(), "goodsName");
            addRecordIfCollectionNotEmpty.accept(data.getTransferUserIds(), "transferUserIds");
            addRecordIfNotEmpty.accept(data.getFollowSituation(), "followSituation");
        });
        handlers.put(BaseConstant.SearchValue.APPRAISAL_CREATE, argsArr -> {
            AppraisalGoodsReq data = (AppraisalGoodsReq) argsArr[0];
            if (CollectionUtils.isNotEmpty(data.getAppraisalGoodsInfoList())) {
                for (AppraisalGoodsInfoReq info : data.getAppraisalGoodsInfoList()) {
                    addRecordIfNotEmpty.accept(info.getBidderId(), "bidderId");
                }
            }
        });
        handlers.put(BaseConstant.SearchValue.SALES_ORDER_CREATE, argsArr -> {
            SalesOrderReqVO data = (SalesOrderReqVO) argsArr[0];
            addRecordIfNotEmpty.accept(data.getBusinessUserId(), "businessUserId");
        });
        handlers.put(BaseConstant.SearchValue.WISH_ORDER_QUERY_PAGE, argsArr -> {
            WishOrderReqVO data = (WishOrderReqVO) argsArr[0];
            addRecordIfNotEmpty.accept(data.getMaintainStaffId(), "maintainStaffId");
        });
        handlers.put(BaseConstant.SearchValue.ABNORMAL_SALES_ORDER_CREATE, argsArr -> {
            AbnormalSalesOrderReqVO data = (AbnormalSalesOrderReqVO) argsArr[0];
            addRecordIfNotEmpty.accept(data.getBusinessUserId(), "businessUserId");
        });
        handlers.put(BaseConstant.SearchValue.ADVANCE_APPLY_CREATE, argsArr -> {
            AdvanceApplyCreateReq data = (AdvanceApplyCreateReq) argsArr[0];
            addRecordIfNotEmpty.accept(data.getSalesmanId(), "salesmanId");
        });
        handlers.put(BaseConstant.SearchValue.ADVANCE_APPLY_REFUND_CREATE, argsArr -> {
            AdvanceApplyRefundCreateReq data = (AdvanceApplyRefundCreateReq) argsArr[0];
            addRecordIfNotEmpty.accept(data.getSalesmanId(), "salesmanId");
        });
        handlers.put(BaseConstant.SearchValue.ARREARS_AMOUNT_ORDER_CREATE, argsArr -> {
            ArrearsAmountOrderVO data = (ArrearsAmountOrderVO) argsArr[0];
            addRecordIfNotEmpty.accept(data.getBusinessUserId(), "businessUserId");
        });
        handlers.put(BaseConstant.SearchValue.REFUND_APPLICATION_CREATE, argsArr -> {
            RefundApplicationReq data = (RefundApplicationReq) argsArr[0];
            addRecordIfNotEmpty.accept(data.getSalesmanId(), "salesmanId");
        });
        handlers.put(BaseConstant.SearchValue.MAINTENANCE_APPLY_CREATE, argsArr -> {
            MaintenanceApplyReq data = (MaintenanceApplyReq) argsArr[0];
            addRecordIfNotEmpty.accept(data.getMaintenanceOrgName(), "maintenanceOrgName");
        });
    }


    public CrmSearchContentRecord setSearchContentRecord(String value, String moduleType, String secondaryModule) {
        CrmSearchContentRecord record = new CrmSearchContentRecord();
        record.setFirstLevelModule(moduleType);
        record.setSecondaryModule(secondaryModule);
        record.setContent(value);

        return record;
    }

    public CrmSearchContentRecord setSearchContentRecord(List<?> value, String moduleType, String secondaryModule) {
        Object o = value.get(0);
        if (o instanceof Long || o instanceof Integer || o instanceof String) {
            String content = (String) value.stream().map(String::valueOf).collect(Collectors.joining(","));
            CrmSearchContentRecord record = new CrmSearchContentRecord();
            record.setFirstLevelModule(moduleType);
            record.setSecondaryModule(secondaryModule);
            record.setContent(content);
            return record;
        }
        return null;
    }


}
*/
