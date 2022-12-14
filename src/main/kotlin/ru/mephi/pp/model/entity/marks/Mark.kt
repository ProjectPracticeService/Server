package ru.mephi.pp.model.entity.marks

import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.user.User
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "marks")
class Mark(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    var project: Project,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,

    @Column(name = "mark")
    @Enumerated(EnumType.STRING)
    var mark: MarkValue,

    @Column(name = "date")
    var date: Timestamp
)