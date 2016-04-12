package com.nibss.nacs.admin;

import com.elixir.springframework.fuse.context.Module;
import com.elixir.springframework.fuse.persistence.Persistence;
import com.elixir.springframework.fuse.persistence.PersistenceUnit;
import com.nibss.nacs.admin.entity.UserIdentity;
import com.nibss.nacs.admin.model.AdminResource;
import org.springframework.boot.orm.jpa.EntityScan;

/**
 * Created by elixir on 4/12/16.
 */
@Module(name = AdminResource.MODULE_NAME,persistence = @Persistence(
        @PersistenceUnit(unitName = "nacs-report-persistence")
))
public class AdminModuleConfiguration {
}
