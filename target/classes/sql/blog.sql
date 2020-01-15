#sql("findGirl")
        select * from blog where 1 = 1
         #if(id)
           and id = #para(id)
        #end
        #if(title)
           and title like #para(title)
        #end
        order by id desc
    #end

    #sql("findTest")
    select distinct dh.*, d.name ProjectName, s.supplier OrganName, p.name HandsPersonName, a.name AccountName, dd.name AllocationProjectName
    from jsh_depothead dh
        left join jsh_depot d on dh.ProjectId=d.id and ifnull(d.delete_Flag,'0') !='1'
        left join jsh_supplier s on dh.OrganId=s.id and ifnull(s.delete_Flag,'0') !='1'
        left join jsh_person p on dh.HandsPersonId=p.id and ifnull(p.delete_Flag,'0') !='1'
        left join jsh_account a on dh.AccountId=a.id and ifnull(a.delete_Flag,'0') !='1'
        left join jsh_depot dd on dh.AllocationProjectId=dd.id and ifnull(dd.delete_Flag,'0') !='1'
        left join jsh_depotitem di on dh.Id = di.HeaderId and ifnull(di.delete_Flag,'0') !='1'
        left join jsh_material m on di.MaterialId = m.Id and ifnull(m.delete_Flag,'0') !='1'
        where 1=1
        #if(type)
           and dh.Type = #para(type)
        #end
        #if(subType)
           and dh.SubType = #para(subType)
        #end
        #if(number)
           and dh.Number = #para(number)
        #end
        #if(beginTime)
           and dh.OperTime = #para(beginTime)
        #end
        #if(endTime)
           and dh.OperTime = #para(endTime)
        #end
        #if(materialParam)
           and (dh.OperTime like count ('%', #para(endTime), '%') or dh.Model like count ('%', #para(endTime), '%'))
        #end
        #if(depotIds)
           and di.DepotId in(#para(depotIds))
        #end
        and ifnull(dh.delete_Flag,'0') !='1'
        order by dh.Id desc
#end



