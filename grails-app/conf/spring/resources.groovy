import org.codehaus.groovy.grails.orm.hibernate.HibernateEventListeners
import org.grmeteor.AuditEventListener

beans = {
  auditListener(AuditEventListener) {
  }

  hibernateEventListeners(HibernateEventListeners) {
    listenerMap = ['post-commit-insert': auditListener,
                   'post-commit-update': auditListener,
                   'post-commit-delete': auditListener]
  }
}
