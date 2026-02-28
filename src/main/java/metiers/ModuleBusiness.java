package metiers;

import entities.Module;
import entities.UniteEnseignement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModuleBusiness {

    private static List<Module> modules;
    private UniteEnseignementBusiness ueBusiness =
            new UniteEnseignementBusiness();

    public ModuleBusiness() {

        if (modules == null) {
            modules = new ArrayList<>();

            modules.add(new Module("M101", "Algorithmique", 3, 30,
                    Module.TypeModule.PROFESSIONNEL,
                    ueBusiness.getUEByCode(1)));

            modules.add(new Module("M102", "Base de données", 2, 20,
                    Module.TypeModule.PROFESSIONNEL,
                    ueBusiness.getUEByCode(1)));

            modules.add(new Module("M201", "Communication", 1, 15,
                    Module.TypeModule.TRANSVERSAL,
                    ueBusiness.getUEByCode(2)));
        }
    }

    public boolean addModule(Module module) {

        if (module.getUniteEnseignement() != null) {

            int code = module.getUniteEnseignement().getCode();
            UniteEnseignement ue = ueBusiness.getUEByCode(code);

            if (ue != null) {
                module.setUniteEnseignement(ue);
                return modules.add(module);
            }
        }
        return false;
    }

    public List<Module> getAllModules() {
        return modules;
    }

    public boolean deleteModule(String matricule) {
        Iterator<Module> iterator = modules.iterator();
        while (iterator.hasNext()) {
            Module m = iterator.next();
            if (m.getMatricule().equals(matricule)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}