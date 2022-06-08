package br.edu.ifsp.scl.ads.pdm.pedrapapeltesoura.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import br.edu.ifsp.scl.ads.pdm.pedrapapeltesoura.Configuracao
import br.edu.ifsp.scl.ads.pdm.pedrapapeltesoura.R
import java.sql.SQLException

class ConfigSqlite(contexto:Context): DAO {

    companion object{
        private val BD_CONF = "jogo"
        private val TABELA_CONF = "configuracoes"
        private val COLUNA_ID = "id"
        private val COLUNA_NUM_JOG = "jogadores"


        val CRIAR_TABELA_CONFIG_STMT = "CREATE TABLE IF NOT EXISTS ${TABELA_CONF} (" +
                "${COLUNA_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${COLUNA_NUM_JOG} INTEGER NOT NULL );"
    }

    private val jogoDb: SQLiteDatabase
    init {
        //Criando ou abrindo o bd e conectando com o db
        jogoDb = contexto.openOrCreateDatabase(BD_CONF, Context.MODE_PRIVATE, null)
        //Criando a tabela
        try {
           jogoDb.execSQL(CRIAR_TABELA_CONFIG_STMT)
           if(recuperarConfiguracao().numeroJogadores == -1){
               criarConfig(Configuracao(2))
           }
        }
        catch (se: SQLException){
            Log.e(contexto.getString(R.string.app_name), se.toString())
        }
    }


    override fun criarConfig(conf: Configuracao): Long {
        val confCv = ContentValues()

        confCv.put(COLUNA_NUM_JOG, conf.numeroJogadores)

        return jogoDb.insert(TABELA_CONF, null,confCv)
    }


    override fun atualizarConfig(config: Configuracao): Int {
        val confCv = ContentValues()
        confCv.put(COLUNA_NUM_JOG, config.numeroJogadores)
        return jogoDb.update(TABELA_CONF,confCv, "$COLUNA_ID = 1", null)

    }


    override fun recuperarConfiguracao(): Configuracao {
        var config = Configuracao()
        val consultaQuery = "SELECT * FROM ${TABELA_CONF} WHERE ${COLUNA_ID} = 1"
        val confCursor = jogoDb.rawQuery(consultaQuery, null)

        if (confCursor.moveToFirst()){
            with(confCursor){
                config = Configuracao(getInt(getColumnIndexOrThrow(COLUNA_NUM_JOG)))
            }
        }
        return config
    }



}
