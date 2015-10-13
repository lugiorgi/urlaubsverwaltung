<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="uv" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <uv:head/>
</head>
<body>

<spring:url var="URL_PREFIX" value="/web"/>

<uv:menu/>

<div class="content">
    <div class="container">
        <div class="row">
            <form:form method="POST" action="${URL_PREFIX}/overtime" modelAttribute="overtime" cssClass="form-horizontal">
                <form:hidden path="person" value="${overtime.person.id}" />
                <div class="form-section">
                    <div class="col-xs-12">
                        <legend><spring:message code="overtime.data"/></legend>
                    </div>
                    <div class="col-md-4 col-md-push-8">
                        <span class="help-block">
                            <i class="fa fa-fw fa-info-circle"></i>
                            <spring:message code="overtime.data.description"/>
                        </span>
                    </div>
                    <div class="col-md-8 col-md-pull-4">
                        <div class="form-group is-required">
                            <label class="control-label col-md-3" for="startDate">
                                <spring:message code="overtime.data.startDate"/>:
                            </label>
                            <div class="col-md-9">
                                <form:input path="startDate" cssClass="form-control" cssErrorClass="form-control error"/>
                                <span class="help-inline"><form:errors path="startDate" cssClass="error"/></span>
                            </div>
                        </div><%-- End of start date form group --%>
                        <div class="form-group is-required">
                            <label class="control-label col-md-3" for="endDate">
                                <spring:message code="overtime.data.endDate"/>:
                            </label>
                            <div class="col-md-9">
                                <form:input path="endDate" cssClass="form-control" cssErrorClass="form-control error"/>
                                <span class="help-inline"><form:errors path="endDate" cssClass="error"/></span>
                            </div>
                        </div><%-- End of end date form group --%>
                        <div class="form-group is-required">
                            <label class="control-label col-md-3" for="numberOfHours">
                                <spring:message code="overtime.data.numberOfHours"/>:
                            </label>
                            <div class="col-md-9">
                                <form:input path="numberOfHours" cssClass="form-control" cssErrorClass="form-control error"/>
                                <span class="help-inline"><form:errors path="numberOfHours" cssClass="error"/></span>
                            </div>
                        </div><%-- End of number of overtime form group --%>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="comment">
                                <spring:message code="overtime.data.comment"/>:
                            </label>
                            <div class="col-md-9">
                                <span id="char-counter"></span><spring:message code="action.comment.maxChars"/>
                                <form:textarea path="comment" cssClass="form-control" rows="2"
                                          onkeydown="maxChars(this,200); count(this.value, 'char-counter');"/>
                                <span class="help-inline"><form:errors path="comment" cssClass="error"/></span>
                            </div>
                        </div><%-- End of comment form group --%>
                    </div>
                </div><%-- End of first form section --%>
                <div class="form-section">
                    <div class="col-xs-12">
                        <hr/>
                        <button class="btn btn-success col-xs-12 col-sm-5 col-md-2" type="submit">
                            <spring:message code="action.save"/>
                        </button>
                        <button class="btn btn-default back col-xs-12 col-sm-5 col-md-2 pull-right" type="button">
                            <spring:message code="action.cancel"/>
                        </button>
                    </div>
                </div><%-- End of second form section --%>
            </form:form>
        </div><%-- End of row --%>
    </div><%-- End of container --%>
</div><%-- End of content --%>

</body>
</html>