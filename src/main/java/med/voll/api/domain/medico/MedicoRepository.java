package med.voll.api.domain.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Aqui podemos adicionar métodos personalizados, se necessário
}
