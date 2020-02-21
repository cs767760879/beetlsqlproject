sample
===
* 注释###

    select #use("cols")# from t_user  where  #use("condition")#

cols
===
	id,name,age,create_date

updateSample
===

	id=#id#,name=#name#,age=#age#,create_date=#createDate#

condition
===

    1 = 1
    @if(!isEmpty(id)){
     and id=#id#
    @}
        @if(!isEmpty(name)){
     and name=#name#
    @}
        @if(!isEmpty(age)){
     and age=#age#
    @}
        @if(!isEmpty(createDate)){
     and create_date=#createDate#
    @}
selectAll
===
select * from t_user

selectUserPage
===
select * from t_user limit #start# , #offset#
