<form>

<f:with bean="estudiante">

        <!-- creando formularios -->
        <div class="form-group" >
        <label for="name">
        <g:message code="estudiante.name.label" default="Nombre" />
        <span class="required-indicator">*</span>
    </label>

    <div class="form-group" >

    <f:widget property="name">
        <g:textField name="name" value="${value}" class="form-control"/>

    </f:widget>

    </div>

    <label for="username">
        <g:message code="estudiante.username.label" default="Username" />
        <span class="required-indicator">*</span>
    </label>

    <div class="form-group" >
    <f:widget property="username">
        <g:textField name="name" value="${value}" class="form-control"/>

    </f:widget>

    </div>

    <!-- creando formularios -->
        <div class="form-group" >
        <label for="codigo">
    <g:message code="codigo.name.label" default="Codigo" />
    <span class="required-indicator">*</span>
    </label>

    <div class="form-group" >

    <f:widget property="codigo">
        <g:textField name="codigo" value="${value}" class="form-control"/>

    </f:widget>

    <!-- creando formularios -->
        <div class="form-group" >
        <label for="correo">
    <g:message code="correo.name.label" default="Correo" />
    <span class="required-indicator">*</span>
    </label>

    <div class="form-group" >

    <f:widget property="correo">
        <g:textField name="correo" value="${value}" class="form-control"/>

    </f:widget>


    <!-- creando formularios -->
        <div class="form-group" >
        <label for="password">
    <g:message code="password.name.label" default="Contraseña" />
    <span class="required-indicator">*</span>
    </label>

    <div class="form-group" >

    <f:widget property="password">
        <g:passwordField name="password" value="${value}" default="Contraseña"/>

    </f:widget>


</f:with>

</form>