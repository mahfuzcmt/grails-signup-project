<meta name="layout" content="public"/>
<div class="card">
    <div class="card-header">
        User Registration
    </div>
    <div class="card-body">
        <form action="/doRegistration" method="POST">
            <g:render template="/user/form"/>
            <g:submitButton name="registration" value="Registration" class="btn btn-primary"/>
        </form>
    </div>
</div>
