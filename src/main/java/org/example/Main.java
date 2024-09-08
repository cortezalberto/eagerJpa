
package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

        EntityManager em = emf.createEntityManager();
        System.out.println("funcionando  Alberto");


            Factura facturaConsultada = em.find(Factura.class, 1L);

            System.out.println("-----PRUEBO LA CARGA LAZY");

        System.out.println(facturaConsultada);

        System.out.println("No te muestro LOS DETALLES");
        System.out.println("---------------------------------------------------");

        System.out.println("Te muestro LA FACTURA");

            // Verificar que los detalles de la factura no se cargan en memoria
            System.out.println("Número de Factura: " + facturaConsultada.getNumeroFactura());
            System.out.println("Cliente: " + facturaConsultada.getCliente());

            // Intentar acceder a la propiedad detalles

                System.out.println(" Aca LLAMO A LOS DETALLES : " + facturaConsultada.getDetalles());




        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}

/*

Manejo del Ciclo de Estados en JPA
El ciclo de estados en JPA (Java Persistence API) define los diferentes estados que puede tener una entidad en relación con el contexto de persistencia (EntityManager). Comprender y manejar correctamente estos estados es crucial para trabajar eficazmente con JPA. Los estados del ciclo de vida de una entidad en JPA son:

New (Nuevo):

Una entidad está en estado "New" cuando ha sido creada pero aún no ha sido persistida en la base de datos.
Managed (Gestionado):

Una entidad está en estado "Managed" cuando está asociada con un contexto de persistencia (EntityManager) y cualquier cambio en la entidad se reflejará automáticamente en la base de datos.
Detached (Desconectado):

Una entidad está en estado "Detached" cuando ya no está asociada con un contexto de persistencia. Los cambios en la entidad no se reflejarán automáticamente en la base de datos.
Removed (Eliminado):

Una entidad está en estado "Removed" cuando ha sido marcada para su eliminación en la base de datos.
*/


